package bronze.raceJan2020;

import java.io.*;
import java.util.Scanner;
/*程序的思想： 想在确定vfinal的情况下尽可能地增大distance, 必然先尽可能地加速，到最大值，然后减速到vfinal
 * 该过程会出现单峰和双峰
 * 如果要求的距离等于单峰或者双峰，或者在两者之间，就一定能实现
 * 具体怎么实现不用管，我们只要知道在t时间下一定能实现，在t+1不能实现
 * 解题思路：
 * 1） brute force vmax, 找到要求地distance在哪两个单峰之间
 * 2）要求的distance距离是否在单峰和双峰之间。
 * */

//watch out for integer overflow
public class Race {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/raceJan2020/9.in"));
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
            System.out.println("vf = " + vFItem);
            long time = -1;
            long distAccelerateToVf = (1 + vFItem) * vFItem / 2;
            if (distAccelerateToVf >= totalDistance) {
                //just keep accelerating
                //time =  (long) Math.ceil(Math.sqrt(totalDistance * 2));
                //find root of a quadratic function
                time = (long) Math.ceil((Math.sqrt(1 + 8 * totalDistance)-1) / 2 );
                System.out.println("1st branch time = " + time);
            } else {
                long vMax = vFItem;
                while (getDistance(vMax, vFItem) < totalDistance) {
                    vMax++;
                }
                //time -1?
                time = (2 * vMax - vFItem);
                long difference = getDistance(vMax, vFItem) - totalDistance;
                //getDistance is equal to totalDistance or the difference is less than vFinal
                if (difference < vFItem) {
                    System.out.println("3rd branch time = " + time);
                } else {
                    if (difference - (vMax - vFItem) < vFItem) {
                        System.out.println("4th branch time=" + time);
                    } else {
                        time--;
                        System.out.println("5th branch time=" + time);
                    }
                }
            }
            System.out.println("just to check time =" + time);
            //why have to convert to string?
            bw.write(Long.toString(time));
            bw.newLine();
        }

        bw.close();
        System.out.println("buffer writer closed");
    }

    static long getDistance(long vMax, long vFinal) {
        return Math.abs((1 + vMax) * vMax / 2 + (vMax - 1 + vFinal) * (vMax - vFinal) / 2);
    }
}
