//package bronze.cowGym2019;

import java.io.*;
import java.util.Scanner;

/*
 * Strategy:
 * 1.read in the line as a 2D array
 * 2.reversely map the 2D array value to index
 * 3.compare vertically the 2D array to check consistency
 * */

public class CowGymDemo {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/cowGym2019/gymnastics_bronze_dec19/1.in"));
        Scanner sc = new Scanner(new File("gymnastics.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/triangle/triangles_bronze_feb20/myOut.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        int K = sc.nextInt();
        int N = sc.nextInt();
        int numPair = N * (N - 1) / 2;

        boolean[] pairConsistency = new boolean[numPair]; //False to be consistent


        int[][] data = new int[K][N];

        for (int i = 0; i < K; i++)
            for (int j = 0; j < N; j++)
                data[i][j] = sc.nextInt() - 1; // minus to make it start from 0

        int[][] reverseMap = new int[K][N];
        for (int i = 0; i < K; i++)
            for (int j = 0; j < N; j++)
                reverseMap[i][data[i][j]] = j;

        int count = 0;
        for (int leftIndex = 0; leftIndex < N - 1; leftIndex++)
            for (int rightIndex = leftIndex + 1; rightIndex < N; rightIndex++) {
                boolean isGreater = reverseMap[0][rightIndex] > reverseMap[0][leftIndex];
                boolean isThisColumnConsistent = true;
                for (int row = 1; row < K; row++)
                    if (reverseMap[row][rightIndex] > reverseMap[row][leftIndex] != isGreater) {
                        isThisColumnConsistent = false;
                        break;
                    }
                if (isThisColumnConsistent)
                    count++;
            }
        pw.print(count);
        pw.close();
    }
}


