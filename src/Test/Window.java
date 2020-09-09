package Test;
import java.util.*;
/**
 * @author cutiewang
 * @date 2020/9/7 23:16
 */
public class Window {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        for(int i =0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 &&   nums[i] == nums[i-1]) continue;
            int left = i+1,right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]+nums[i]<0){
                    left++;
                }else if(nums[left]+nums[right]+nums[i]>0){
                    right--;
                }else{
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    list.add(tmp);
                    while(left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
