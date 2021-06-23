package BinarySearch;

/*
万用型？最后留下两个值
循环条件： l < r-1 相邻就结束
缩减搜索空间： l = mid, r = mid
[1,4]
[1，1]
[3,4]
 */
public class ClosestToTwo {
    public static void main(String[] args) {

    }

    static int binarySearch(int[] arr, int k) {
        int l=0, r = arr.length -1;
        while (l < r-1){
            int mid = l + (r-l)/2;
            if (arr[mid] < k){
                l = mid;
            }else {
                r = mid;
            }
        }

        //最终选出两个值，三种情况，
        //1）k落在区间中 2）k落在区间右边 3）k落在区间左边
        if (arr[r] < k) {
            return r;
        } else if (arr[l] > k) {
            return l;
        } else {
            return k-arr[l] < arr[r]-k ?l : r;
        }
    }

}
