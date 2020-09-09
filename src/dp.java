
import java.util.*;

/**
 * @author cutiewang
 * @date 2020/7/28 17:10
 */
public class dp {
//    static int ans;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        Deque[] list = new Deque[n];
//        int j = 0;
//        for(int t = 0 ;t<n; t++){
//            int k = in.nextInt();
//            Deque tmp = new LinkedList();
//            for(int i = 0;i<k;i++){
//                tmp.add(in.nextInt());
//            }
//            list[j++] = tmp;
//        }
//        // list:[[3],[3,2],[1,4,1,5]]
//        in.close();
//        dp solve = new dp();
//        solve.maxValue(list,0,m);
//        System.out.println(ans);
//    }
//    //递归每次要做的事情是啥呢 是对每一层元素进行左右去除后看看是否是最大
//    private void maxValue(Deque[] lists, int cur,int m){
//        //
//        if(m == 0){
//            ans = Math.max(cur,ans);
//        }
//        for(int i = 0;i<lists.length;i++){
//            //左边
//            if(lists[i].size()==0){
//                continue;
//            }
//            Integer first = (Integer) lists[i].removeFirst();
//            maxValue(lists,cur+first,m-1);
//            //恢复原状
//            lists[i].addFirst(first);
//            // 右边
//            Integer last = (Integer) lists[i].removeLast();
//            maxValue(lists,cur+last,m-1);
//            //
//            lists[i].addLast(last);
//        }
//    }
    public String maxPaxlidome(String s){
        int ans =0;
        String ret = "";
        for(int i = 0;i<s.length();i++){
            String odd = centerHelp(s,i,i);//以奇数扩展
            String ou = centerHelp(s,i,i+1);//以偶数扩展
            String tmp = odd.length()>ou.length()?odd:ou;
            if(tmp.length()>ans) {ret = tmp; ans = tmp.length();}
        }
        return ret;
    }
    public String centerHelp(String a,int left,int right){
        while(left>=0 && right<a.length() && a.charAt(left) == a.charAt(right)){
            left--;
            right++;
        }
        return a.substring(left+1,right);
    }
    public int findMaxSub(int[] arr){
        int cnt = 0,left=0;
        int ret = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == 0) cnt++;
            while(cnt>1){
                if(arr[left] == 0) cnt--;
                left++;
            }
            ret = Math.max(ret,i-left);
        }
        return ret;
    }

    public static void main(String[] args) {
        dp dp = new dp();
        dp.maxPaxlidome("babad");
    }
}
