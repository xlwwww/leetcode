package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author cutiewang
 * @date 2020/6/24 22:08
 * 动态代理client端使用
 */
public class test1 {
    public static void main(String[] args) {
        //1. 创建委托类对象
        UserServiceImpl userService = new UserServiceImpl();
        //2. 创建调用处理器
        MyProxy h = new MyProxy(userService);
        //3. 构造代理类对象
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),h);
        proxy.sell();
        proxy.add();
    }
}
