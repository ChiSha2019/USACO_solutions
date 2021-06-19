package silver.Prefix;

public class PrefixDemo {
    public static void main(String[] args) {
        int[] originalArray = {0,1,6,4,2,5,3};
        int[] prefixAray = new int[originalArray.length];

        //dump way time complexity O(n^2)
        for (int i=0; i<prefixAray.length;i++){
            int sum = 0;
            for (int j=0; j<originalArray.length;j++){
                sum += originalArray[j];
            }
            prefixAray[i] = sum;
        }

        //smart way
        prefixAray[0] = originalArray[0];
        for (int i=1; i<prefixAray.length;i++){
            prefixAray[i] = prefixAray[i-1] + originalArray[i];
        }
    }
}
