package bronze.cowGym2019;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

//Strategy: store into a 2d array, check difference in each column
//if there's a difference rule means there's a swap
//But how to make sure we dont double count the already occured pairs?
// use hashmap with key as future number to store previous pairs
public class CowGym {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("gymnastics.in"));
        Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/cowGym2019/gymnastics_bronze_dec19/3.in"));
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();

        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/cowGym2019/gymnastics_bronze_dec19/myOut.out")));

        int[][] cowArray = new int[rowNum][colNum];

        for (int i = 0; i < rowNum; i++)
            for (int j = 0; j < colNum; j++)
                cowArray[i][j] = sc.nextInt();
        int totalCombNum = colNum * (colNum - 1) / 2;
        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int col = 0; col < colNum; col++)
            for (int row = 0; row < rowNum; row++)
                //if such key already exists?Dont do anything
                //in this coloumn, all differencet from the top number
                //this pair havent been counted yet
                if (!pairs.containsKey(cowArray[row][col]) &&
                        cowArray[row][col] != cowArray[0][col] &&
                        (pairs.containsKey(cowArray[0][col])&& cowArray[row][col] != pairs.get(cowArray[0][col]) || !pairs.containsKey(cowArray[0][col]))
                )
                    pairs.put(cowArray[row][col], cowArray[0][col]);

        System.out.println(pairs);
        pw.println(totalCombNum - pairs.size());
        pw.close();
    }
}
