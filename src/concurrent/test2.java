package concurrent;

/**
 * @author cutiewang
 * @date 2020/3/15 15:57
 */
public class test2 {
    public static void main(String[] args) throws InterruptedException {
        twoPhaseTerminate tpt = new twoPhaseTerminate();
        tpt.start();
        Thread.sleep(2000);
        tpt.stop();
    }
}
class twoPhaseTerminate{
    private Thread monitor;
    public void start(){
        monitor=new Thread(()->{
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("interrupt");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("monitoring");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
        monitor.start();
    }
    public void stop(){
        monitor.interrupt();
    }
}