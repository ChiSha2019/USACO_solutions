package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int e: nums) System.out.println(e);
        for(int i=0; i<nums.length-2; i++){
            int j=i+1;
            int k= nums.length-1;
            while (j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0){
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    newList.add(nums[k]);
                    if (!result.isEmpty() && !result.contains(newList))result.add(newList);
                    break;
                }else if (sum >0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return result;
    }
}
