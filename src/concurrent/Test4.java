package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cutiewang
 * @date 2020/3/22 10:56
 */
public class Test4 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static boolean isC1 = false;
    private static boolean isC2 = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            lock.lock();
            System.out.println("线程1获取到锁");
            try{
                while(!isC1){
                    System.out.println("条件不满足 线程1等待");
                    try {
                        c1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("条件满足 线程1做事");
                } finally {
                    System.out.println("线程1释放锁");
                    lock.unlock();
                }


        }).start();
        new Thread(()->{
            lock.lock();
            System.out.println("线程2获取到锁");
                try {
                    while (!isC2) {
                        System.out.println("条件不满足 线程2等待");
                        try {
                            c2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("条件满足 线程2做事");
                } finally {
                    lock.unlock();
                }

        }).start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                isC1 = true;
                c1.signal();
                Thread.sleep(1000);
                isC2 = true;
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
