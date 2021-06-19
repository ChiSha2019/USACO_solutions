package BinarySearch;
/*模糊搜索
[1,1,2,2,2,6,7]
[1,1,1,2,2,6,7]
[2,3] -- 用来判断缩减区间
循环条件：l<r
缩减搜索空间：l = mid,r = mid-1
 */
public class LastOccurenceOfTwo {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,6,7};
        int[] arr2 = {1,1,2,2,5,6,7};
        int[] arr3 = {2,3};
        System.out.println(binarySearch(arr1,2));
        System.out.println(binarySearch(arr2,2));
        System.out.println(binarySearch(arr3,2));
    }

    static int binarySearch(int[] arr, int k){
        int l=0, r = arr.length-1;
        while(l<r) {
            int mid = l + (r-l+1)/2;//why+1,因为考虑到[2,3]
            // 如果l已经在2上面了，mid = (r+l)/2仍然指向2，违反缩减区间
            if(arr[mid] > k) {
                r = mid - 1; //why mid-1? because
            } else {
                l = mid;
            }
        }
        return r;
    }

    static int binarySearch2(int[] arr, int k){
        int l=0, r = arr.length-1;
        while(l<r) {
            int mid = l + (r-l+1)/2;
            if(arr[mid] < k) {
                l = mid+1;
            }else if(arr[mid] == k){
                l = mid; //why mid-1? because
            } else {
                r = mid-1; //
            }
        }
        return r;
    }
}
