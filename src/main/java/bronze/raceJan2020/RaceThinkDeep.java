//package bronze.raceJan2020;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RaceThinkDeep {
    public static void main(String[] args) throws IOException {        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/raceJan2020/9.in"));
        Scanner sc = new Scanner(new File("race.in"));
        BufferedWriter bw;
        //bw = new BufferedWriter(new FileWriter("src/main/java/bronze/raceJan2020/myRace.out"));
        bw = new BufferedWriter(new FileWriter("race.out"));
        long totalDistance = sc.nextInt();
        int testNum = sc.nextInt();
        long[] finalV = new long[testNum];
        int index = 0;
        while (sc.hasNext()) {
            finalV[index] = sc.nextInt();
            index++;
        }

        for (long vFItem : finalV) {
            long time = -1;
            long distAccelerateToVf = (1 + vFItem) * vFItem / 2;
            if (distAccelerateToVf >= totalDistance) {
                //just keep accelerating
                //time =  (long) Math.ceil(Math.sqrt(totalDistance * 2));
                //find root of a quadratic function
                time = (long) Math.ceil((Math.sqrt(1 + 8 * totalDistance)-1) / 2 );
            } else {
                double timeDecimal = Math.sqrt(2*vFItem*vFItem+4*totalDistance-2*vFItem)-vFItem;
                time = (long) Math.ceil(timeDecimal);
            }
            //why have to convert to string?
            bw.write(Long.toString(time));
            bw.newLine();
        }

        bw.close();
    }
}
