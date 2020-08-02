package concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cutiewang
 * @date 2020/3/26 11:41
 */
public class test1 {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
/*        //获取 自增是原子的                          打印     i
        //++i
        System.out.println(i.incrementAndGet());//1       1
        //i++
        System.out.println(i.getAndIncrement());//1       2
        System.out.println(i.getAndAdd(2));//2       4
        System.out.println(i.addAndGet(2));//6       6*/



        System.out.println(i.updateAndGet(x->x*10));
    }
}
