package concurrent.byOrder;

import java.util.ArrayList;

/**
 * @author cutiewang
 * @date 2020/3/22 15:04
 * 实现线程的顺序控制 两线程交替输出1212121212
 */
public class Test5 {
    private final static Object lock = new Object();
    /*flag represent is 1 should be print or not */
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(1);
                    flag = false;
                    lock.notifyAll();
                }
            }
    });
    Thread t2 = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                while (flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = true;
                System.out.println(2);
                lock.notifyAll();
            }
        }
    });
    ArrayList<Integer> s = new ArrayList<>();

        t1.start();
        t2.start();
        t1.interrupt();
        t2.interrupt();
}
}
