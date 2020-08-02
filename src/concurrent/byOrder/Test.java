package concurrent.byOrder;

import java.util.concurrent.locks.LockSupport;

/**
 * @author cutiewang
 * @date 2020/3/22 16:32
 * park unpark 实现三个线程abcabcabcabcabc
 * 注意park unpark 是针对线程的
 */
public class Test {
    static Thread t1;
    static Thread t2;
    static Thread t3;
    public static void main(String[] args) throws InterruptedException {
        ParkUnpark park = new ParkUnpark(5);
        t1 = new Thread(()->{
            park.print("a",t2);
        });

        t2 = new Thread(()->{
            park.print("b",t3);
        });
        t3 = new Thread(()->{
            park.print("c",t1);
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
    }
}
class ParkUnpark{
    int loopNum;

    public ParkUnpark(int loopNum) {
        this.loopNum = loopNum;
    }
    public void print(String c, Thread next){
        for(int i = 0;i<loopNum;i++){
            LockSupport.park();
            System.out.print(c);
            LockSupport.unpark(next);
        }

    }
}