package BinarySearch;

/*
* 分类讨论，1. mid落在左边的山 2. mid落在右边的山
*
*
*
* */

public class leetcode33_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {1,3};
        search(arr, 3);
    }

    static public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            System.out.println(" l = " + l + "," + " r = " + r + "," + " mid = " + mid);
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] >= nums[l]) {
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }else {
                    if (target > nums[l]){
                        r = mid - 1;
                    }else if (target > nums[mid] && target <= nums[r]){
                        l = mid + 1;
                    } else {
                        r = mid -1;
                    }
                }
            }
        }
        return -1;
    }
}
