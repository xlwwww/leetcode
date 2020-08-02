package concurrent.volatile_test;

/**
 * @author cutiewang
 * @date 2020/3/23 19:53
 */
public class jmm {
    static boolean run = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(true){
                if(run){
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread. sleep(1000);
        run = true;
    }
}
