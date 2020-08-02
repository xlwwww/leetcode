package concurrent;

/**
 * @author cutiewang
 * @date 2020/3/21 10:20
 * 保护性暂停模式
 */
public class GuardedSus_test {
    public static void main(String[] args) {
        //线程1等待线程2下载完成
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            try {
                String a = (String) guardedObject.get();
                System.out.println(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            guardedObject.set((Object)"12345");
        }).start();
    }
}
class GuardedObject{
    private  Object response;
    public Object get() throws InterruptedException {
        synchronized (this){
            while(response == null){
                System.out.println("condition not satisfy");
                this.wait();
            }
            return response;
        }
    }
    public void set(Object value){
        synchronized (this){
            response = value;
            this.notifyAll();
        }
    }

}