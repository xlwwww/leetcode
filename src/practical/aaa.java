package practical;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cutiewang
 * @date 2020/6/2 19:13
 */
public class aaa {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, column = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                if(queue.size()<k){
                    queue.add(matrix[i][j]);
                }else{
                    if(queue.peek()>matrix[i][j]){
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int left = 1, right = n;
        while(left<right){
            int mid = (left + right) /2;
            int cntL = 0, cntR = 0;
            for(int i = 0;i<=n;i++){
                if(nums[i]>mid){
                    cntR++;
                }else cntL++;
            }
            if(cntL>mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> m = new HashMap();
        for(int i =0;i<n;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        int max = 0,maxKey = nums[0];
        for(int key:m.keySet()){
            if(m.get(key)>max){
                maxKey = key;
                max = m.get(key);
            }
        }
        int start = 0,end = n;
        for(int i = 0;i<n;i++){
            if(nums[i] == maxKey){
                start = i;
                break;
            }
        }
        for(int i = n-1;i>=0;i--){
            if(nums[i] == maxKey){
                end = i;
                break;
            }
        }
        return end-start+1;
    }
    public static void main(String[] args) {
        aaa a = new aaa();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        //a.kthSmallest(matrix,8);
        int[] nums = {1,2,2,3,1};
        //a.findDuplicate(nums);
        //a.findShortestSubArray(nums);
        Object tmp = new Object();

    }
}
