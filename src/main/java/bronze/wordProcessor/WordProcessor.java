package bronze.wordProcessor;

import java.io.*;
import java.util.Scanner;

public class WordProcessor {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/triangle/triangles_bronze_feb20/2.in"));
        Scanner sc = new Scanner(new File("word.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/triangle/triangles_bronze_feb20/myOut.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        int numWord = sc.nextInt();
        int maxCharLength = sc.nextInt();
        String[] words = new String[numWord];
        int index = 0;
        while (sc.hasNext()) {
            words[index] = sc.next();
            index++;
        }

        int currentLength = 0;
        for (int i=0; i<words.length; i++){
            if (words[i].length() + currentLength > maxCharLength){
                pw.println();
                pw.print(words[i]);
                currentLength = words[i].length();
            }else {
                pw.print(words[i]);
                currentLength += words[i].length();
            }
            if (i<numWord && words[i+1].length() + currentLength <= maxCharLength){
                pw.write(" ");
            }
        }
        pw.close();
        
    }
}
