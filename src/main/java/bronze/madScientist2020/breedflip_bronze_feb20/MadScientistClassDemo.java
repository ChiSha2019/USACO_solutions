//package bronze.madScientist2020.breedflip_bronze_feb20;

/*
* 1.understand the question
* 2.think abt the strategy
* 3.translate your strategy into your code
*
* strategy:
*  int numFlip = 0
*  traverse through string A and B and compare them
*  if there is a different substring
*       increase numFlip by 1
*
* there is a different substring == check is current charater is the start of a new dif block
* current character is dif and last character is the same
* */

import java.io.*;
import java.util.Scanner;

public class MadScientistClassDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("breedflip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        int numCow = sc.nextInt();
        String strA = sc.next();
        String strB = sc.next();

        int numFlip = 0;
        if (strA.charAt(0) != strB.charAt(0))
            numFlip ++;

        for(int i =1; i<numCow; i++){
            if (strA.charAt(i) != strB.charAt(i) && strA.charAt(i-1) == strB.charAt(i-1)) {
                numFlip ++;
            }
        }
        pw.println(numFlip);
        pw.close();
    }
}
