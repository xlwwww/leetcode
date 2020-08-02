/**
 * @author cutiewang
 * @date 2020/1/21 22:17
 */
public class jvmLearn {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
    }
}
