package concurrent;

/**
 * @author cutiewang
 * @date 2020/3/19 16:01
 */
public class simulate_tea {
    public static void main(String[] args) throws InterruptedException {
        /*模拟烧水喝茶过程*/
        Thread t = new Thread(()->{
            System.out.println("preparation last 4 min");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        System.out.println("wash the pot");
        Thread.sleep(1000);
        System.out.println("boil water");
        Thread.sleep(5000);
        t.join();
        System.out.println("泡茶");

    }
}
