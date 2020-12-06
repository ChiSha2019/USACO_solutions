package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] myarr = {4,3,2,10,12,1,5,6};
        sort(myarr);
        for (int item : myarr)
            System.out.print(item + " ");

    }
    static void sort(int[] arr){
        //index of the 1st element in the right part
        for (int i=1; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            //shift all the elements in the left part greater than key right
            while (j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            //insert the key to the position
            arr[j+1] = key;
        }
    }
}
