package IOstream;

import java.io.*;
import java.util.Scanner;

//question: print out the triples that adds up to 20
//Sample output:
//6 9 5
//3 4 13
//11 0 9
//please write this output to a file
public class ReadFileInClassExercise1 {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("/Users/qixia/IdeaProjects/USACO/src/main/java/IOstream/ReadFileInClassExercise1.in");
        Scanner scanner = new Scanner(inputFile);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/IOstream/fileWriterOutput.out")));
        while(scanner.hasNext()) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            if (num1+num2+num3 == 20){
                pw.println(num1 + " " + num2 + " " + num3);
            }
        }
        pw.close();
    }
}
