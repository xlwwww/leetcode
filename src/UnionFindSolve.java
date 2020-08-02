import java.io.InputStream;
import java.util.HashMap;

/**
 * @author cutiewang
 * @date 2020/3/10 9:39
 */
public class UnionFindSolve {
    class UnionFind{
        int max;
        HashMap<Integer,Integer> parent;
        HashMap<Integer,Integer> size;
        UnionFind(int[] nums){
            max = 1;
            parent = new HashMap<>();
            size = new HashMap<>();
            for(Integer i:nums){
                parent.put(i,i);
                size.put(i,1);
            }
        }
        public int find(int v){
            if(parent.get(v) == v){
                return v;
            }
            return find(parent.get(v));
        }
        public void union(int v1, int v2){
            int root1= find(v1);
            int root2 = find(v2);
            if(root1!=root2){
                parent.put(root1,root2);
                int tmp_size = size.get(root1)+size.get(root2);
                size.put(root2,tmp_size);
                max = Math.max(tmp_size,max);
            }
        }
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        UnionFind u = new UnionFind(nums);
        for(Integer i: nums){
            if(u.parent.containsKey(i-1)){
                u.union(i-1,i);
            }
        }
        return u.max;
    }

    public static void main(String[] args) {
        UnionFindSolve s = new UnionFindSolve();
        s.longestConsecutive(new int[]{1,2,0,1});
    }
}
