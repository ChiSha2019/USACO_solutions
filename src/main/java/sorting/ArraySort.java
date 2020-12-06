package sorting;


import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] myArray = {2,3,5,6,7,1};
        Arrays.sort(myArray);
        for(int i : myArray)
            System.out.println(i);
    }
}
