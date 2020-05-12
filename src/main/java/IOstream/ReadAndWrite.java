package IOstream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadAndWrite {

    public static void main(String[] args) throws IOException {
        //scan the input file and store it into an array
        File input = new File("src/main/java/IOstream/toRead.in"); //intellij's relative path start from project
        Scanner sc = new Scanner(input);
        int length = sc.nextInt();
        String[] str = new String[length];
        int index = 0;
        while(sc.hasNext()){
            str[index] = sc.next();
            index++;
        }

        //display it
        for (String item : str)
            System.out.println(item);

        //write "This" "is" "output" "file" into a new file call "myOutput"
        BufferedWriter bw;
        FileWriter fw = new FileWriter("src/main/java/IOstream/myOutput.out");
        bw = new BufferedWriter(fw);
        bw.write("This\n");
        bw.write("is\n");
        bw.write("output\n");
        bw.write("file");
        bw.close();

    }
}
