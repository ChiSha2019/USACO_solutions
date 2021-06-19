package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nn = {1,1,-1,-1,3};
        int result = threeSumClosest(nn, -1);
        System.out.println(result);
    }
    public static int threeSumClosest(int[] nums, int target) {
        int result=0;
        int difference = 40000;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int j=i+1;
            int k= nums.length-1;
            while (j < k){
                int sum = nums[i]+nums[j]+nums[k];
                System.out.println("sum = " + sum);
                if (Math.abs(sum - target) == 0){
                    return sum;
                }else if (Math.abs(sum - target) < difference){
                    difference = Math.abs(sum - target);
                    result = sum;
                }else if (sum - target >0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return result;
    }
}
