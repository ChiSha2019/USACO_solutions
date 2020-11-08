package bronze.photoShootJan2020;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PhotoShootClassDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("photo.in"));
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/photoShootJan2020/1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/photoShootJan2020/myout.out")));
        int numCow =  sc.nextInt();
        int[] b = new int[numCow-1];
        for (int i=0; i<numCow-1; i++)
            b[i] = sc.nextInt();
        Set setA = new LinkedHashSet<Integer>();

        for (int i =1; i<= numCow; i++){
            boolean isGood = true;
            int nextNum = i;
            setA.add(i);
            for (int j=0; j<numCow-1;j++){
                nextNum = b[j] - nextNum;
                //check whether nextNum is an element in permutation
                if(nextNum > numCow || nextNum < 1 || setA.contains(nextNum)){
                    isGood = false;
                    setA.clear();
                    break;
                }else {
                    setA.add(nextNum);
                }
            }
            if (isGood){
                int index = 1;
                for (Object item : setA){
                    pw.print(item);
                    if (index < numCow)
                        pw.print(" ");
                    index ++;
                }
                pw.close();
                break;
            }
        }
    }

}
