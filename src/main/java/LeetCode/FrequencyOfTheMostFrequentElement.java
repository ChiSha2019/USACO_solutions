package LeetCode;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int[] inputNum = {1,2,4};
        System.out.println(maxFrequency(inputNum, 3));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        long sum =0;
        int ans = 0;
        for (int r=0; r<nums.length; r++){
            sum += nums[r];
            System.out.println("windowArea = " + (long)nums[r]*(r-l+1));
            while (l<r && sum+k < (long)nums[r]*(r-l+1)) {
                sum -= nums[l];
                System.out.println("sum = " + sum);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
