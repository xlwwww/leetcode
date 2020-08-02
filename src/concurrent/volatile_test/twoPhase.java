package concurrent.volatile_test;

/**
 * @author cutiewang
 * @date 2020/3/23 20:04
 * 两阶段终止模式的volatile实现
 */
public class twoPhase {
    private volatile boolean stop = false;

    public void start(){
        new Thread(()->{
            while(true){
                if(stop) break;
                try {
                    Thread.sleep(200);
                    System.out.println("t1...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void stop(){
        stop = true;
    }
    public static void main(String[] args) throws InterruptedException {
        twoPhase twoPhase = new twoPhase();
        twoPhase.start();
        Thread.sleep(3000);
        twoPhase.stop();
    }
}
