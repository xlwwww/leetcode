package concurrent.ThreadPool;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author cutiewang
 * @date 2020/3/29 11:37
 */
public class test1 {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(1,1000,TimeUnit.MILLISECONDS,1,
                (queue,task)->{
            //用户自己定义拒绝策略
                    queue.put(task);
                });
        for(int i = 0;i<3;i++){
            int j = i;
            pool.execute(()->{
                System.out.println(j);
            });
        }
    }
}
class ThreadPool{
    //阻塞队列
    private BlockQueue<Runnable> queue;

    //线程集合 --->线程用包装类Worke表达
    private HashSet<Worker> workers = new HashSet<>();

    private int coreThread;
    private long timeout;
    private TimeUnit unit;
    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreThread, long timeout, TimeUnit unit,int queueSize,RejectPolicy rejectPolicy) {
        queue = new BlockQueue<>(queueSize);
        this.coreThread = coreThread;
        this.timeout = timeout;
        this.unit = unit;
        this.rejectPolicy = rejectPolicy;
    }

    //执行方法
    public void execute(Runnable task){
        synchronized (workers){
            if(workers.size()<coreThread){
                //新增worker
                System.out.println("新增worker");
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else{
                System.out.println("加入队列");
//                queue.put(task);
                //1.死等
                //2.带超时等待
                //3.放弃任务
                //4.抛出异常
                //5.自己执行任务
                /*策略模式，具体实现抽象为接口，由调用者实现*/
                queue.tryPut(rejectPolicy,task);
            }
        }
    }

    class Worker extends Thread{
        Thread thread;
        String name;
        Runnable task;
        Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            //当传过来一个任务，则执行任务
            //task执行完毕，接着从任务队列获取任务执行
            while(task!=null || (task = queue.pull(timeout,unit))!=null) {
                try {
                    System.out.println("正在执行"+task);
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            synchronized (workers){
                System.out.println("worker移除"+this);
                workers.remove(this);
            }
        }
    }
}
@FunctionalInterface
interface RejectPolicy<T>{
    void reject(BlockQueue<T> queue,T task);
}
//实现多线程下的阻塞队列
class BlockQueue<T>{
    //队列
    private Deque<T> waitList;

    //锁
    private ReentrantLock lock = new ReentrantLock();

    boolean isFull ;
    boolean isEmpty;
    int size;
    Condition condition_get = lock.newCondition();
    Condition condition_put = lock.newCondition();

    BlockQueue(int size){
        waitList = new LinkedList<>();
        isEmpty = true;
        isFull = false;
        this.size = size;
    }

    //阻塞添加
    public void put(T task){
        lock.lock();
        try{
            while(waitList.size() == size){
                try {
                    condition_put.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            waitList.add(task);
            if(waitList.size() == size){
                isFull = true;
            }
            condition_get.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //阻塞获取
    public T getTask(){
        lock.lock();
        try{
            while(waitList.isEmpty()){
                try {
                    condition_get.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = waitList.poll();
            if(waitList.size() == 0){
                isEmpty = true;
            }
            condition_put.signalAll();
            return task;
        } finally {
            lock.unlock();
        }
    }

    //带超时的阻塞获取
    public T pull(long timeout, TimeUnit unit){
        lock.lock();
        try{
            //将超时时间转换为纳秒
            long nanos = unit.toNanos(timeout);
            while(waitList.isEmpty()){
                try {
                    //返回剩余时间
                    if(nanos<=0){
                        return null;
                    }
                    nanos = condition_get.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = waitList.poll();
            if(waitList.size() == 0){
                isEmpty = true;
            }
            condition_put.signalAll();
            return task;
        } finally {
            lock.unlock();
        }
    }

    //带超时的阻塞添加
    public boolean offer(T task,long timeout, TimeUnit unit){
        lock.lock();
        try{
            long nanos = unit.toNanos(timeout);
            while(waitList.size() == size){
                try {
                    if(nanos<=0){
                        return false;
                    }
                    nanos = condition_put.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            waitList.add(task);
            if(waitList.size() == size){
                isFull = true;
            }
            condition_get.signalAll();
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try{
            //队列满了
            if(waitList.size() == size){
                rejectPolicy.reject(this,task);
            }else{
                this.put(task);
            }
        }finally {
            lock.unlock();
        }
    }
}
