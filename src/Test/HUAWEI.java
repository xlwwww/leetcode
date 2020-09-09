package Test;

import java.util.*;

/**
 * @author cutiewang
 * @date 2020/9/8 16:18
 */
public class HUAWEI {
    public int[][] reconstructQueue(int[][] people) {
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//        [[4,4], [5,2], [5,0],[6,1],[7,1],[7,0]]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        int[][] ret = new int[people.length][2];
        List<Integer> idxs = new ArrayList<>();
        for(int i =0;i<people.length;i++){
            idxs.add(i);
        }
        for(int i = 0;i<people.length;i++){
            ret[idxs.get(people[i][1])] = people[i];
            idxs.remove(people[i][1]);
        }
        return ret;
    }

    public static void findPathinMatrix(String word) {
        if(word == null || word.length()==0) {System.out.println(true);return;}
        char[][] map = new char[][]{  {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        boolean[][] visited = new boolean[3][4];
        boolean ret =false;
        for(int i = 0;i<3;i++){
            for(int j =0;j<4;j++){
                if(map[i][j] == word.charAt(0)){
                    if(findPath(map,i,j,visited,0,word)){
                        System.out.println(true);
                        return;
                    }
                }
            }
        }
        System.out.println(false);

    }
    private static boolean findPath(char[][] map,int i,int j,boolean[][] visited,int idx,String s){
        if(i>=3 || i<0 ||j>=4 || j<0 || visited[i][j] || s.charAt(idx)!=map[i][j]) return false;
        if(idx == s.length()-1) return true;
        visited[i][j] = true;
        if(findPath(map,i+1,j,visited,idx+1,s) ||
        findPath(map,i-1,j,visited,idx+1,s) ||
        findPath(map,i,j+1,visited,idx+1,s) ||
        findPath(map,i,j-1,visited,idx+1,s)) return true;
        visited[i][j] = false;
        return false;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i =0;i<n;i++){
            while(nums[i]>0 && nums[i]<n && nums[i]!=nums[nums[i]-1]){
                swap(nums,nums[i]-1,i);
            }
        }
        int ret=1;
        for(int i =0;i<n;i++){
            if(nums[i]!=i-1) { ret = i;break;}
        }
        return ret;
    }
    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
