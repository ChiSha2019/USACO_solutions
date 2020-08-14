package bronze.madScientist2020;

import java.io.*;
import java.util.Scanner;

public class MadScientist {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/madScientist2020/breedflip_bronze_feb20/3.in"));
        Scanner sc = new Scanner(new File("breedflip.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/madScientist2020/breedflip_bronze_feb20/myout.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        int length = sc.nextInt();
        String strA = sc.next();
        String strB = sc.next();
        boolean same = true;
        int count =0;
        for(int i=0; i<length;i++){

            if (strA.charAt(i) != strB.charAt(i) && same){
                    count ++;
                }
            same = strA.charAt(i) == strB.charAt(i);
        }
        pw.println(count);
        pw.close();
    }
}
