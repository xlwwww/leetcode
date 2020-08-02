package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author cutiewang
 * @date 2020/3/14 20:53
 */
public class myThread {

    //创建线程方式1
/*    public static void main(String[] args) {
        Runnable mr = ()->{
            System.out.println("this is new thread");
        };
        Thread t = new Thread(mr);
        t.start();
        System.out.println("main");
    }*/

    //创建线程方式2 FutureTask
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> f = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int cnt=0;
                for(int i = 0;i<100;i++){
                    cnt ++;
                }
                return cnt;
            }
        });
        Thread t = new Thread(f,"t1");
        t.start();
        System.out.println(f.get());

    }



}
