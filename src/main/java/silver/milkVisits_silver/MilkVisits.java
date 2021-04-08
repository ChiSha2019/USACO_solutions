/*
strategy:
https://www.youtube.com/watch?v=cd6Iqk0ltiM&ab_channel=StarLeague
1.Union all those connected farm with same type.
2.compare each query node pair
    1)if they are in same set -> check if the type is what they need
    2)not in same set -> return true!

 */

//package silver.milkVisits_silver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MilkVisits {
    public static void main(String[] args) throws Exception {

        // Read in the basic graph parameters.
        BufferedReader stdin = new BufferedReader(new FileReader("milkvisits.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int numQ = Integer.parseInt(tok.nextToken());

        // Type of cow at each node.
        char[] type = stdin.readLine().toCharArray();

        // Create our disjoing set.
        Djset ds = new Djset(n);

        // As we read in the edges, we only union the two vertices if the cows there are the same type.
        for (int i=0; i<n-1; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int v1 = Integer.parseInt(tok.nextToken())-1;
            int v2 = Integer.parseInt(tok.nextToken())-1;
            if (type[v1] == type[v2]) ds.union(v1, v2);
        }

        // Store result here.
        char[] res = new char[numQ];
        Arrays.fill(res, '0');

        // Go through each query.
        for (int i=0; i<numQ; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int v1 = Integer.parseInt(tok.nextToken())-1;
            int v2 = Integer.parseInt(tok.nextToken())-1;
            char t = tok.nextToken().charAt(0);

            // Just change the yes's.
            if (type[v1] == t || type[v2] == t || ds.find(v1) != ds.find(v2))
                res[i] = '1';
        }

        // Output to file.
        PrintWriter out = new PrintWriter(new FileWriter("milkvisits.out"));
        out.println(new String(res));
        out.close();
        stdin.close();
    }
}

// A disjoint set with path compression.
class Djset {

    public int[] par;

    public Djset(int n) {
        par = new int[n];
        for (int i=0; i<n; i++) par[i] = i;
    }

    public int find(int v) {
        if (par[v] == v) return v;
        return par[v] = find(par[v]);
    }

    public boolean union(int v1, int v2) {
        if (find(v1) == find(v2)) return false;
        par[v2] = v1;
        return true;
    }

}