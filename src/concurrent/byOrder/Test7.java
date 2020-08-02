package concurrent.byOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cutiewang
 * @date 2020/3/22 15:54
 * Reentrantlock 实现三个线程abcabcabcabcabc
 */
public class Test7 {
    static Lock lock = new Lock();

    public static void main(String[] args) throws InterruptedException {
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        new Thread(()->{
            lock.print('a',a,b);
        }).start();
        new Thread(()->{
            lock.print('b',b,c);
        }).start();
        new Thread(()->{
            lock.print('c',c,a);
        }).start();
        Thread.sleep(1000);
        /*必须上锁才能唤醒----->成为owner*/
        lock.lock();
        try {
            a.signal();
        }finally {
            lock.unlock();
        }
    }
}

class Lock extends ReentrantLock{

    public void print(char c,Condition cur,Condition next){
        for(int i =0;i<5;i++){
            this.lock();
            try{
                cur.await();
                /*await 必须要在打印之前，因为在之后的话没办法控制开始执行谁真正先打印*/
                System.out.println(c);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }
}