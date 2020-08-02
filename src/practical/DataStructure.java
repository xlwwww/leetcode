package practical;

/**
 * @author cutiewang
 * @date 2020/7/5 15:28
 */
import java.util.Stack;
public class DataStructure {
    Stack<Integer> s = new Stack();
    Stack<Integer> min = new Stack();
    int m = Integer.MAX_VALUE;
    public void push(int node) {
        s.push(node);
        if(node<min.peek()){
            min.push(node);
        }else min.push(min.peek());
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.push(3);
        ds.push(4);
        ds.push(2);
        ds.push(3);
        ds.pop();
        ds.pop();
        ds.pop();
        ds.min();
    }
}
