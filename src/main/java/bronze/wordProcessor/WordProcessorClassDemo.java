//package bronze.wordProcessor;

import java.io.*;
import java.util.Scanner;

//have currentLength referring the existing number of character in current line
//if currentLength + length of next word > maxNumOfCharEachLine:
// change line and currentLength = length of next word
//else:
// append next word to cuurent line , currentLength += length of next word
public class WordProcessorClassDemo  {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("word.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        int numOfWords = sc.nextInt();
        int maxNumOfCharEachLine = sc.nextInt();
        String[] words = new String[numOfWords];
        int index = 0;
        while (sc.hasNext()){
            words[index] = sc.next();
            index++;
        }

        int currentLength = 0;
        for (int i=0; i< numOfWords; i++) {
            if (currentLength + words[i].length() > maxNumOfCharEachLine){
                pw.println();
                pw.print(words[i]);
                currentLength = words[i].length();
            }else {
                pw.print(words[i]);
                currentLength += words[i].length();
            }
            //print space after each word but not at the end of each line
            if (i < numOfWords-1 && currentLength + words[i+1].length() <= maxNumOfCharEachLine)
                pw.write(" ");
        }
        pw.close();
    }
}
