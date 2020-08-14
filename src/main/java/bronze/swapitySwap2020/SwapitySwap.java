package bronze.swapitySwap2020;

import java.io.*;
import java.util.Scanner;
//Strategy: the reversed result is cyclic. We need to find its period and
//find the remainder of revering time over the period
public class SwapitySwap {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/swapitySwap2020/swap_bronze_feb20/3.in"));
        Scanner sc = new Scanner(new File("swap.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/swapitySwap2020/swap_bronze_feb20/myOut.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int[] cows = new int[n];
        int[] originalCows = new int[n];
        boolean isBrokenFromLoop = false;
        int period = 0;
        for (int i = 0; i < n; i++) {
            cows[i] = i + 1;
            originalCows[i] = i + 1;
        }
        for (int i = 0; i < k; i++) {
            reverse(cows, a1, a2);
            reverse(cows, b1, b2);
            //printArray(cows);
            if (isSame(cows, originalCows)) {
                period = i + 1;
                isBrokenFromLoop = true;
                break;
            }
        }

        //System.out.println(period);


        //can improve this by using a 2d array to record the result
        if (isBrokenFromLoop) {
            int numIteration = k % period;
            for (int i = 0; i < numIteration; i++) {
                reverse(cows, a1, a2);
                reverse(cows, b1, b2);
            }
        }

        for (int item : cows)
            pw.println(item);
        pw.close();
    }

    static boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    static void reverse(int[] array, int start, int end) {
        //start-1 is index
        for (int i = start - 1, j = end - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

     static void printArray(int[] inputArray) {
        for (Integer element : inputArray){
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

}
