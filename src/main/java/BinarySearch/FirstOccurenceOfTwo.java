package BinarySearch;

/*模糊搜索
[1,1,2,2,2,6,7]
[1,1,1,2,2,6,7]
[2,3]
循环条件：l<r
缩减搜索空间：l = mid+1,r = mid
 */
public class FirstOccurenceOfTwo {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,6,7};
        int[] arr2 = {1,1,1,2,2,6,7};
        int[] arr3 = {2,3};
        System.out.println(binarySearch(arr1,2));
        System.out.println(binarySearch(arr2,2));
        System.out.println(binarySearch(arr3,2));
    }
    static int binarySearch(int[] arr, int k) {
        int l =0, r = arr.length - 1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if (arr[mid] < k) { //固定
                l = mid +1; //mid值小于2，所以mid被淘汰掉,
            }else {
                r = mid; //mid,可以保留
            }
        }
        return l;
    }
}
