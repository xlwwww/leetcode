/**
 * @author cutiewang
 * @date 2020/4/25 20:08
 */
import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Main {
//    public String depress(int pos,char[] s){
//        String res = "";
//        Stack stack = new Stack<>();
//        while(pos<s.length){
//            if(s[pos] == ']'){
//                //todo
//                String tmp = "";
//                while((stack.peek() instanceof Character && (char)stack.peek()!='[') || stack.peek() instanceof String){
//                        tmp = stack.pop()+tmp;
//                }
//                stack.pop();
//                String[] x = tmp.split("\\|");
//                int num = Integer.parseInt(x[0]);
//                String ss = "";
//                while(num>0){
//                    num--;
//                    ss += x[1];
//                }
//                stack.push(ss);
//            }else{
//                stack.push(s[pos]);
//            }
//            pos++;
//        }
//        int n = stack.size();
//        for(int i= 0;i<n;i++){
//            res += stack.get(i);
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String strings = sc.nextLine();
//        Main m = new Main();
//        System.out.println(m.depress(0,strings.toCharArray()));
//    }
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int[][] step = new int[n][n];
//    int[][] dp = new int[n][n];
//    for(int i=0;i<n;i++){
//        for(int j = 0;j<i+1;j++){
//            step[i][j] = sc.nextInt();
//        }
//    }
//    dp[0][0] = step[0][0];
//    for(int i =1;i<n;i++){
//        for(int j = 0;j<=i;j++){
//            if(j-1<0){
//                dp[i][j] = step[i][j]+dp[i-1][j];
//            }else dp[i][j] = step[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
//        }
//    }
//    int res = 0;
//    for(int i =0;i<n;i++){
//        res = Math.max(res,dp[n-1][i]);
//    }
//    System.out.println(res);
//}
    HashMap<Character,Integer> map = new HashMap();
    ArrayList<Character> list = new ArrayList();
    public void Insert(char ch)
    {
        map.put(ch,map.getOrDefault(ch,0)+1);
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(Character ch:list){
            if(map.get(ch)==1){
                return ch;
            }
        }
        return '#';
    }
    public int GetNumberOfK(int [] array , int k) {
        int start = 0,end = array.length-1;
        int ans = 0;
        while(start<=end){
            int mid = (end+start)/2;
            if(k>array[mid]) start = mid+1;
            else if(k<array[mid]) end = mid;
            else
            {
                ans++;
                for(int i=mid-1;i>=0;i--){
                    if(array[i] == k) ans++;
                    else break;
                }
                for(int i=mid+1;i<array.length;i++){
                    if(array[i] == k) ans++;
                    else break;
                }
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] tower = new int[n];
//        for (int i = 0; i < n; i++) {
//            tower[i] = sc.nextInt();
//        }
        Main m = new Main();
        int [] a = new int[]{1,2,2,2,2,2,3,3,3,4};
        m.GetNumberOfK(a,4);
    }
}
