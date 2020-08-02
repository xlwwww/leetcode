package dynamicProxy;

/**
 * @author cutiewang
 * @date 2020/6/24 22:40
 * 实现了接口的委托类
 */
public class UserServiceImpl implements UserService {
    @Override
    public int sell() {
        System.out.println("selling...");
        return 0;
    }

    @Override
    public int add() {
        System.out.println("adding...");
        return 0;
    }
}
