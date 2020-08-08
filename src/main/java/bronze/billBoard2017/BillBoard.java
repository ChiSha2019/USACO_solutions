package bronze.billBoard2017;
import java.util.*;
import java.io.*;
public class BillBoard {
    public static void main(String[] args) throws Exception {

        // Read the grid.
        Scanner stdin = new Scanner(new File("billboard.in"));

        // Mark both seen billboards.
        boolean[][] see = new boolean[2001][2001];
        for (int i=0; i<2; i++) {

            int x1 = stdin.nextInt()+1000;
            int y1 = stdin.nextInt()+1000;
            int x2 = stdin.nextInt()+1000;
            int y2 = stdin.nextInt()+1000;

            for (int x=x1; x<x2; x++)
                for (int y=y1; y<y2; y++)
                    see[x][y] = true;
        }

        // Mark squares that can't be seen.
        int x1 = stdin.nextInt()+1000;
        int y1 = stdin.nextInt()+1000;
        int x2 = stdin.nextInt()+1000;
        int y2 = stdin.nextInt()+1000;
        for (int x=x1; x<x2; x++)
            for (int y=y1; y<y2; y++)
                see[x][y] = false;

        // Count which ones can be seen now.
        int res = 0;
        for (int i=0; i<=2000; i++)
            for (int j=0; j<2000; j++)
                if (see[i][j])
                    res++;

        // Ta da!
        PrintWriter out = new PrintWriter(new FileWriter("billboard.out"));
        out.print(res);
        out.close();
        stdin.close();
    }
}
