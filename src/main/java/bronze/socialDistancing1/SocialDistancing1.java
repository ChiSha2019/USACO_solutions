package bronze.socialDistancing1;

/*
 * strategy:
 * 1) evenly divide the largest gap into 3 subgaps
 * 2) put 2 cows at each end
 * 3) put 1 cow at left end, find the largest gap, and put
 * the other cow at the middle
 * 4) put 1 cow at right end, find the largest gap, and put
 * the other cow at the middle
 * 5) find the largest gap, inset the cow at middle, then repeat it
 *
 * try above-mentioned strategies, find their max closest distance,
 * compare them and return the largest one
 * */

import java.io.*;
import java.util.Scanner;

public class SocialDistancing1 {
    static int largestGapStart = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/socialDistancing1/1.in"));
        //Scanner sc = new Scanner(new File("socdist1.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/socialDistancing1/myout.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
        int stallNum = sc.nextInt();
        String stallString = sc.next();

        char[] stallCharArray = stallString.toCharArray();
        int answer = 0;
        int largestGap = findLargestInteriorGap(stallCharArray);

        //1.put two cows in the largest interior gap
        if (largestGap >= 3) {
            char[] tempt = stallString.toCharArray();
            tempt[largestGapStart + largestGap / 3] = '1';
            tempt[largestGapStart + largestGap * 2 / 3] = '1';
            answer = Math.max(answer, findSmallestInteriorGap(tempt));
        }

        //2.put cows at both ends
        if (stallCharArray[0] == '0' && stallCharArray[stallNum - 1] == '0') {
            char[] tempt = stallString.toCharArray();
            tempt[0] = '1';
            tempt[stallNum - 1] = '1';
            answer = Math.max(answer, findSmallestInteriorGap(tempt));
        }

        //3.put one cow at left, the other at the middle of the largest gap
        if (stallCharArray[0] == '0') {
            char[] tempt = stallString.toCharArray();
            tempt[0] = '1';
            answer = Math.max(answer, tryCowInLargestGap(tempt));
        }

        //4.put one cow at right, the other at the middle of the largest gap
        if (stallCharArray[stallNum - 1] == '0') {
            char[] tempt = stallString.toCharArray();
            tempt[stallNum - 1] = '1';
            answer = Math.max(answer, tryCowInLargestGap(tempt));
        }

        //5. put cow at largest interior gap. done twice
        if (largestGap >= 2) {
            char[] tempt = stallString.toCharArray();
            tempt[largestGapStart + largestGap / 2] = '1';
            answer = Math.max(answer, tryCowInLargestGap(tempt));
        }
        System.out.println(answer);
        pw.print(answer);
        pw.close();
    }

    static int findLargestInteriorGap(char[] theList) {
        int biggestGap = 0;
        int currentStart = -1;

        for (int i = 0; i < theList.length; i++) {
            if (theList[i] == '1') {
                if (currentStart != -1 && i - currentStart > biggestGap) {
                    biggestGap = i - currentStart;
                    largestGapStart = currentStart;
                }
                currentStart = i;
            }
        }
        return biggestGap;
    }

    static int findSmallestInteriorGap(char[] stallList) {
        int smallestGap = stallList.length;
        int currentStart = -1;
        for (int i = 0; i < stallList.length; i++) {
            if (stallList[i] == '1') {
                if (currentStart != -1 && i - currentStart < smallestGap) {
                    smallestGap = i - currentStart;
                }
                currentStart = i;
            }
        }
        return smallestGap;
    }

    //put the cow at the middle of the largest gap
    static int tryCowInLargestGap(char[] stallList) {
        int largestGap = findLargestInteriorGap(stallList);
        //evenly divide the largest gap
        if (largestGap >= 2) {
            stallList[largestGapStart + largestGap / 2] = '1';
            return findSmallestInteriorGap(stallList);
        }
        return -1;
    }
}
