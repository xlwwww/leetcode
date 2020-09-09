package Test;

import javax.security.auth.Refreshable;
import java.awt.print.Pageable;
import java.util.*;

/**
 * @author cutiewang
 * @date 2020/9/6 20:01
 */
class UnionFind{
    int[] elements;
    int size;
    HashMap<Integer,Integer> map;
    UnionFind(int size) {
        elements = new int[size];
        this.size = size;
        for(int i =0;i<size;i++){
            elements[i] =i;
        }
        map = new HashMap<>();
    }
    public int find(int i){
        while(i!=elements[i]){
            i = elements[i];
        }
        return i;
    }
    public boolean isConnect(int f,int s){
        return find(f) == find(s);
    }
    public int getCnt(int i){
        int root = find(i);
        return map.get(root);
    }
    public void union(int p ,int q){
        int first = find(p);
        int sec = find(q);
        if(first==sec){
            return ;
        }
        elements[first] = sec;
    }
}
public class Tecent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] group = new ArrayList[m];
        HashSet<Integer> set = new HashSet<>();
        UnionFind unionFind = new UnionFind(n);
        int cnt = 0;
        for(int i = 0;i<m;i++){
            int x = in.nextInt();
            int first = in.nextInt();
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(first);
            for(int j =1;j<x;j++){
                int ss = in.nextInt();
                unionFind.union(first,ss);
                tmp.add(ss);
            }
            group[i] =tmp;
        }
        for(int i =0;i<m;i++){
            for(Integer ss:group[i]){
                if(unionFind.isConnect(0,ss) && !set.contains(ss)){
                    set.add(ss);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
//public class Tecent{
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        newNode[] arr = new newNode[n];
//        for(int i =0;i<n;i++){
//            arr[i] = new newNode(in.nextInt(),i);
//        }
//        Arrays.sort(arr, new Comparator<newNode>() {
//            @Override
//            public int compare(newNode newNode, newNode t1) {
//                return newNode.val-t1.val;
//            }
//        });
//        int mid = arr[n/2].val;
//        int midL = arr[n/2-1].val;
//        int[] ans = new int[n];
//        for(int i =0;i<n;i++){
//            int idx = arr[i].idx;
//            if(arr[i].val>=mid){
//                ans[idx] = midL;
//            }else if(arr[i].val<=midL){
//                ans[idx] = mid;
//            }
//        }
//        for(int i =0;i<n;i++){
//            System.out.println(ans[i]);
//        }
//    }
//
//}
//class newNode{
//    int val;
//    int idx;
//    newNode(int val,int idx){
//        this.val = val;
//        this.idx = idx;
//    }
//}
