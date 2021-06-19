package sorting;

public class QuickSort {
    public static void main(String[] args) {

    }

    void quickSort(int[] n, int low, int high) {
        if (low < high) {
            int pivot_location = partition(n, low, high);
            quickSort(n, low, pivot_location);
            quickSort(n, pivot_location + 1, high);
        }
    }

    int partition(int[] n, int low, int high) {
        int pivot = n[low]; //pivot index is low
        int leftwall = low;

        for (int i = low + 1; i <= high; i++) {
            if (n[i] < pivot) {
                swap(n, i, leftwall);
                leftwall++;
            }
        }
        swap(n, 0, leftwall);
        return leftwall;
    }

    void swap(int[] n, int a, int b) {
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }


}
