package reflection;
import java.lang.reflect.*;

/**
 * @author cutiewang
 * @date 2020/6/24 16:52
 * reflection learning and test
 */
public class test1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> klass = method.class;
        //创建反射实例
        Object o = klass.newInstance();
        //获取方法
        Method method = klass.getDeclaredMethod("add",int.class,int.class);
        //调用方法
        try {
            Object result = method.invoke(o, 1, 4);
            System.out.println(result);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class method{
    int a = 2;
    public int add(int a,int b){
        return a+b;
    }
    public  int sub(int a, int b){
        return a-b;
    }
}