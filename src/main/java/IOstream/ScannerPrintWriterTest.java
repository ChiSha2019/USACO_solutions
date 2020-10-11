package IOstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerPrintWriterTest {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        // str = sc.next();
        String str = "sOMETHING TO pRINT";
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/main/java/IOstream/fileWriterOutput.out")));
        pw.print(str);
        pw.close();
    }
}
