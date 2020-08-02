package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cutiewang
 * @date 2020/6/24 22:40
 * 调用处理器对象
 */
public class MyProxy implements InvocationHandler {

    private Object target; //委托类对象

    public MyProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        before();
        Object result = method.invoke(target,objects); // invoke 委托类对象的method方法
        after();
        return result; //返回委托类方法结果
    }
    void before(){
        System.out.println("before..");
    }
    void after(){
        System.out.println("after..");
    }
}
