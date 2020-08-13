package bronze.dont_be_last_2017;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DontBeLast {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("notlast.in"));
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/dont_be_last_2017/notlast_bronze_jan17/1.in"));
        int len = sc.nextInt();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/dont_be_last_2017/notlast_bronze_jan17/notlast.out")));
        HashMap<String, Integer> mapNameToMilk = new HashMap<String, Integer>();
        String name = "";
        int milk = 0;
        if (len > 1) {
            for (int i = 0; i < len; i++) {
                name = sc.next();
                milk = sc.nextInt();
                if (mapNameToMilk.containsKey(name)) {
                    Integer curMilk = mapNameToMilk.get(name);
                    mapNameToMilk.put(name, curMilk + milk);
                } else {
                    mapNameToMilk.put(name, milk);
                }
            }

/*            mapNameToMilk.forEach(
                    (key, value) -> System.out.println(key + "---" + value)
            );*/


            int minMilk = Integer.MAX_VALUE;
            int secondMinMilk = minMilk;
            String minName = "";
            String secondMinName = "";
            for (Map.Entry<String, Integer> entry : mapNameToMilk.entrySet()) {
                if (entry.getValue() < minMilk) {
                    secondMinMilk = minMilk;
                    secondMinName = minName;
                    minMilk = entry.getValue();
                    minName = entry.getKey();
                } else if (entry.getValue() < secondMinMilk && entry.getValue() != minMilk) {
                    secondMinMilk = entry.getValue();
                    secondMinName = entry.getKey();
                }
/*                System.out.println("minMilk = " + minMilk + "    "
                        + "minName = " + minName + "    "
                        + "secondMinMilk = " + secondMinMilk + "    "
                        + "secondMinName = " + secondMinName);*/
            }

            //for test case 3
            if (secondMinName.isEmpty()) {
                pw.print("Tie");
                pw.close();
            } else {
                pw.print(secondMinName);
                pw.close();
            }
        } else {
            name = sc.next();
            pw.print(name);
            pw.close();
        }
    }
}
