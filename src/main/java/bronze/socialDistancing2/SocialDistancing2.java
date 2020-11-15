//package bronze.socialDistancing2;
/*
1. find max R = min gap between a healthy and a sick cow
2. find the number of independent sick cluster
        a) find sick blocks (start with 1 and end with 1, no -1 in between)
        b) find independent block <=> find the num of gap between sick cows (gap > R)

 */
import java.io.*;
import java.util.Scanner;

public class SocialDistancing2 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/socialDistancing2/1.in"));
        Scanner sc = new Scanner(new File("socdist2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/socialDistancing2/MYOUT.out")));
        int N = sc.nextInt();
        int[] A = new int[1000001];
        for (int i = 0; i < 1000001; i++)
            A[i] = 0;

        for (int i = 0; i < N; i++) {
            int index = sc.nextInt();
            int sickOrHealthy = sc.nextInt();
            if (sickOrHealthy == 1)
                A[index] = 1;
            else {
                A[index] = -1;
            }
        }

        int r = find_smallest_sick_healthy_gap(A);
        pw.println(num_sick_cluster(A)+numSickGapGreaterThanR(A,r));
        pw.close();
    }
    static int find_smallest_sick_healthy_gap(int[] A){
        int smallest_gap = A.length;
        int leftStart = -1;
        for (int i = 0; i < 1000001; i++){
            if (A[i] != 0){
                if (leftStart != -1 && A[leftStart] != A[i] && i - leftStart < smallest_gap){
                    smallest_gap = i - leftStart;
                }
                leftStart = i;
            }
        }
        return smallest_gap;
    }

    static int num_sick_cluster(int[] A){
        int leftState = 0;
        int numSickCluster = 0;
        for (int i = 0; i < 1000001; i++) {
            if(A[i] != 0){
                if (A[i] != leftState && A[i] == 1){
                    numSickCluster ++;
                }
                leftState = A[i];
            }
        }
        return numSickCluster;
    }

    static int numSickGapGreaterThanR(int[] A, int r){
        int answer = 0;
        int leftStart = 0;
        for (int i = 0; i < 1000001; i++) {
            if (A[i] !=0){
                if (leftStart !=0 && A[leftStart] == 1 && A[i] == 1 && i - leftStart >= r){
                    answer++;
                }
                leftStart = i;
            }
        }
        return answer;
    }

}
