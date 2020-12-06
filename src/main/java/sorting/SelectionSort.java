package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5,1,12,-5,16,2,12,14};
        int[] sortedArray = selectionSort(array);
        for (int item : sortedArray)
            System.out.print(item+" ");
    }
    static int[] selectionSort(int[] unsortedArray){
        int n = unsortedArray.length;
        //travels through the array with the index of the 1st element of the right part
        for (int i = 0; i<n; i++){

                //find min in right part
                int min_idx = i;
                for (int j = i+1; j<n; j++){
                    if (unsortedArray[j] < unsortedArray[min_idx])
                        min_idx = j;
                }

            //swap the min with 1st elemnt in right part
            int temp = unsortedArray[min_idx];
            unsortedArray[min_idx] = unsortedArray[i];
            unsortedArray[i] = temp;

        }
        return unsortedArray;
    }
}
