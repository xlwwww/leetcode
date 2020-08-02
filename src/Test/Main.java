package Test;

import java.math.BigInteger;
import java.net.CookieHandler;
import java.util.*;

/**
 * @author cutiewang
 * @date 2020/7/29 15:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = (in.nextInt());
        }
        while(m>0){
            int Min = Integer.MAX_VALUE;
            for(Integer c : num){
                Min = Math.min(Min,c);
            }
            for(int i = 0;i<num.length;i++){
                if(num[i] == Min){
                    num[i] +=x;
                }
            }
            m--;
        }
        Arrays.sort(num);
        System.out.println(num[0]);

    }

}
