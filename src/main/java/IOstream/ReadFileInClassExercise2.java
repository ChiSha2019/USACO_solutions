package IOstream;

import java.io.*;
import java.util.Scanner;

public class ReadFileInClassExercise2 {
    public static void main(String[] args) throws IOException {
        File inputF = new File("/Users/qixia/IdeaProjects/USACO/src/main/java/IOstream/ReadFileInClassExercise2.in");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/IOstream/fileWriterOutput.out")));
        Scanner scanner = new Scanner(inputF);
        while (scanner.hasNextLine()){
            int count = scanner.nextInt();
            if (count == 1){
                pw.println(count + " " + scanner.next());
            }else {
                pw.println(count + " " + scanner.next() + "s");
            }
        }
        pw.close();
    }
}
