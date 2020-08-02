
import java.util.*;

/**
 * @author cutiewang
 * @date 2020/7/28 17:10
 */
public class dp {
    static int ans;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque[] list = new Deque[n];
        int j = 0;
        for(int t = 0 ;t<n; t++){
            int k = in.nextInt();
            Deque tmp = new LinkedList();
            for(int i = 0;i<k;i++){
                tmp.add(in.nextInt());
            }
            list[j++] = tmp;
        }
        // list:[[3],[3,2],[1,4,1,5]]
        in.close();
        dp solve = new dp();
        solve.maxValue(list,0,m);
        System.out.println(ans);
    }
    //递归每次要做的事情是啥呢 是对每一层元素进行左右去除后看看是否是最大
    private void maxValue(Deque[] lists, int cur,int m){
        //
        if(m == 0){
            ans = Math.max(cur,ans);
        }
        for(int i = 0;i<lists.length;i++){
            //左边
            if(lists[i].size()==0){
                continue;
            }
            Integer first = (Integer) lists[i].removeFirst();
            maxValue(lists,cur+first,m-1);
            //恢复原状
            lists[i].addFirst(first);
            // 右边
            Integer last = (Integer) lists[i].removeLast();
            maxValue(lists,cur+last,m-1);
            //
            lists[i].addLast(last);
        }
    }
}
