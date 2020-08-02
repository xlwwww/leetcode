package concurrent.byOrder;

/**
 * @author cutiewang
 * @date 2020/3/22 15:35
 * 三个线程abcabcabcabcabc
 */
public class Test6 {
    public static void main(String[] args) {
        WaitFlag waitFlag = new WaitFlag(1,5);
        new Thread(()->{
            try {
                waitFlag.print("a",1,2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                waitFlag.print("b",2,3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                waitFlag.print("c",3,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
class WaitFlag{
    /*state 1 ---- a
     *      2 ---- b
     *      3 ---- c
     * */
    private int flag;
    private int loopNum;

    public WaitFlag(int flag, int loopNum) {
        this.flag = flag;
        this.loopNum = loopNum;
    }
    public void print(String str, int waitFlag,int nextFlag) throws InterruptedException {
        for(int i=0;i<loopNum;i++){
            synchronized (this){
                while(flag!=waitFlag){
                    this.wait();
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}