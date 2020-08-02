package concurrent;

import java.util.LinkedList;

/**
 * @author cutiewang
 * @date 2020/3/21 11:30
 * 生产者消费者模式 消息队列
 */
public class Test3{
    public static void main(String[] args) {
        MessageQ q = new MessageQ(2);
        for(int i = 0;i<3;i++){
            int id = i;
            new Thread(()->{
                try {
                    q.put(new Message(id,"生产者·"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    q.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
class MessageQ {
    private LinkedList<Message> list = new LinkedList<>();
    private int capacity;

    public MessageQ(int capacity) {
        this.capacity = capacity;
    }

    //获取消息
    public Message take() throws InterruptedException {
        synchronized (list){
            while(list.isEmpty()){
                System.out.println("队列为空");
                list.wait();
            }
            Message m = list.removeFirst();
            System.out.println("已消费"+m.toString());
            list.notifyAll();
            return m;
        }
    }

    //存入消息
    public void put(Message message) throws InterruptedException {
        synchronized (list){
            while(list.size() == capacity){
                System.out.println("队列满了");
                list.wait();
            }
            list.addLast(message);
            System.out.println("已生产"+message.toString());
            list.notifyAll();
        }
    }

}
class Message{
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
