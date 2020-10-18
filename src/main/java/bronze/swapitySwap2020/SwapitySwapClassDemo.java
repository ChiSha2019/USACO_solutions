package bronze.swapitySwap2020;

import java.io.*;
import java.util.Scanner;

public class SwapitySwapClassDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("swap.in"));
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/swapitySwap2020/swap_bronze_feb20/1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/swapitySwap2020/swap_bronze_feb20/myout.out")));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();

        int[] cows = new int[n];
        int[] cows_copy = new int[n];

        int period = 0;
        //boolean isCyclic = false;

        for (int i = 0; i < n; i++) {
            cows[i] = i + 1;
            cows_copy[i] = i + 1;
        }

        // reverse
        for (int i = 0; i < k; i++) {
            reverse(cows, a1, a2);
            reverse(cows, b1, b2);
            if (isSame(cows, cows_copy)) {
                period = i + 1;
                //isCyclic = true;
                break;
            }
        }
        /*two cases:
        when k < period: simply reverse k time and print the array
        when k >= period: calculate remainder = k % period,
        reverse remainder time and print the array
        */

        if (period > 0) {
            int remainder = k % period;
            for (int i = 0; i < remainder; i++) {
                reverse(cows, a1, a2);
                reverse(cows, b1, b2);
            }
        }


        for (int item : cows) {
            pw.println(item);
        }

        pw.close();

    }

    static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item);
        }
        System.out.println();
    }

    static boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    static void reverse(int[] array, int start, int end) {
        int i = start - 1;
        int j = end - 1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
