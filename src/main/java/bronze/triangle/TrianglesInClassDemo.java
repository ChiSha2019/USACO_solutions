package bronze.triangle;
/*
 * 1. Understand question thoroughly
 * 2. Think of strategy in a mathematical way
 *   1)brute forcely find all three points combinations
 *       question : how many combinations? 4
 *        (0,0) (0,1) (1,0)
 *        (0,0) (0,1) (1,2)
 *        (0,0) (1,0) (1,2)
 *        (0,1) (1,0) (1,2)
 *
 *   2)check whether each three points can form a valid triangle
 *   3)calculate the area of this valid triangle
 *   4)find the max area
 * 3. Translate your strategy into Java
 *
 * */


import java.io.*;
import java.util.Scanner;

public class TrianglesInClassDemo {
    public static void main(String[] args) throws IOException {

        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/triangle/triangles_bronze_feb20/2.in"));
        Scanner sc = new Scanner(new File("triangles.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/triangle/triangles_bronze_feb20/myOut.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int numPoint = sc.nextInt();
        int[] x = new int[numPoint];
        int[] y = new int[numPoint];
        for (int i = 0; i < numPoint; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int maxArea = 0;

        for (int i = 0; i < numPoint - 2; i++)
            for (int j = i + 1; j < numPoint - 1; j++)
                for (int k = j + 1; k < numPoint; k++) {
                    if ((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) &&
                            (y[i] == y[j] || y[i] == y[k] || y[j] == y[k]))
                    {
                            int newArea = area(x[i],y[i],x[j],y[j],x[k],y[k]);
                            if (newArea>maxArea)
                                maxArea = newArea;
                    }
                }

        pw.println(maxArea);
                pw.close();
    }

    static int area(int x1,int y1,int x2,int y2,int x3,int y3){
        return Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
    }
}
