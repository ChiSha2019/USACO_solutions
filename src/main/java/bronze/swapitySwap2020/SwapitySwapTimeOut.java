//package bronze.swapitySwap2020;

import java.io.*;
import java.util.Scanner;

public class SwapitySwapTimeOut {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/swapitySwap2020/swap_bronze_feb20/2.in"));
        //Scanner sc = new Scanner(new File("swap.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/swapitySwap2020/swap_bronze_feb20/myOut.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i < n; i++)
            cows[i] = i + 1;
        for (int i = 0; i < k; i++) {
            reverse(cows, a1, a2);
            reverse(cows, b1, b2);
        }
        for (int item : cows)
            pw.println(item);
        pw.close();
    }

    static void reverse(int[] array, int start, int end) {
        //start-1 is index
        for (int i = start - 1, j = end -1; i < j ; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

/*            for (int item : array)
                System.out.print(item);
            System.out.println();*/
        }
    }
}
