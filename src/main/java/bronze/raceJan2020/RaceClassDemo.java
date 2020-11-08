//package bronze.raceJan2020;

import java.io.*;
import java.util.Scanner;

/*
* to travel max distance in a given time. We have to accelkertae as much as possible then
* deccerate to meet vfinal
* with different final velocity, 2 secenarios:
* 1)if Vfinal is too great or distance is too great, mean we can keep accelerate without dropping speed
*     t = (sqrt(8d+1)-1)/2
* 2)if Vfinal is not great, we have increase then decrease speed
*   t = -vf + sqrt (2vf^2-2vf+4d)
* */
public class RaceClassDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("race.in"));
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/photoShootJan2020/1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/photoShootJan2020/myout.out")));
        int totalDistance = sc.nextInt();
        int testNum = sc.nextInt();
        int[] vf = new int[testNum];
        for (int i=0;i<testNum; i++)
            vf[i] = sc.nextInt();

        for (int vfitem : vf){
            int time;
            int distOnlyAccelerate = (1+vfitem)*vfitem/2;
            if (totalDistance >= distOnlyAccelerate){
                time = (int)Math.ceil((Math.sqrt(1+8*totalDistance)-1)/2);
            }else{
                time = (int)Math.ceil(Math.sqrt(2*vfitem*vfitem-2*vfitem+4*totalDistance)-vfitem);
            }
            pw.println(time);
        }
        pw.close();
    }
}
