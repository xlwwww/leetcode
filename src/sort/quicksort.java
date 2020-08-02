package sort;

import java.util.Collections;

/**
 * @author cutiewang
 * @date 2020/3/13 10:47
 */
public class quicksort {
    public void quicksort(int[]arr,int L,int R){
        if(L>=R) return;
        int[] rr = partition(arr,L,R);
        quicksort(arr,L,rr[0]);
        quicksort(arr,rr[1],R);
    }
    public int[] partition(int[] arr,int L, int R){
        int less = L-1;
        int more = R;
        int cur = L;
        int num = arr[R];
        while (cur< more){
            if(arr[cur]<num){
                swap(arr,less++,cur++);
            }else if(arr[cur]>num){
                swap(arr,more-1,cur);
                more--;
            }else cur++;
        }
        return new int[]{less,more};
    }
    public void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
