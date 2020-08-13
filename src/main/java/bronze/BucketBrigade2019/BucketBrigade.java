package bronze.BucketBrigade2019;


import java.io.*;
import java.util.Scanner;

public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        //read in input as a 2d array
        Scanner sc = new Scanner(new File("buckets.in"));
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/BucketBrigade2019/buckets_bronze_open19/8.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/BucketBrigade2019/buckets_bronze_open19/mybucket.out")));

        int b_x = -1;
        int b_y = -1;
        int r_x = -1;
        int r_y = -1;
        int l_x = -1;
        int l_y = -1;
        char[][] farm = new char[10][10];
        for (int i=0; i<10;i++){
            String strline = sc.next();
            for (int j=0; j<10; j++){
                switch (strline.charAt(j)){
                    case 'B' :
                        b_x = i;
                        b_y = j;
                        break;
                    case 'R':
                        r_x = i;
                        r_y = j;
                        break;
                    case 'L':
                        l_x = i;
                        l_y = j;
                        break;
                }
                farm[i][j] = strline.charAt(j);
            }
        }
        //print2D(farm);
        int dis = Math.abs(b_x-l_x) + Math.abs(b_y-l_y) - 1;
        // B,R,L are in same line and R is in between B and L
        if ((b_x == r_x && b_x == l_x &&  (b_y < r_y && r_y < l_y || l_y < r_y && r_y < b_y))
                || (b_y == r_y && b_y == l_y && (b_x < r_x && r_x < l_x || l_x < r_x && r_x < b_x))){
            dis += 2;
        }

        pw.print(dis);
        pw.close();


    }
/*    public static void print2D(char mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}
