//package gold.closingthefarm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class closing_the_farm_gold {
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO_solutions_java/src/main/java/gold/closingthefarm/5.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO_solutions_java/src/main/java/gold/closingthefarm/closing.out")));
        Scanner sc = new Scanner(new File("closing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i=1; i<=N; i++){
            adjList[i] = new ArrayList<Integer>();
        }

        //read in all the edges
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }

        int[] reverse_close_node = new int[N];
        for (int i = 0; i < N; i++) {
            reverse_close_node[N - 1 - i] = sc.nextInt();
        }

        DisjointSet ds = new DisjointSet(N);

        boolean[] isConnected = new boolean[N];
        boolean[] visited = new boolean[N + 1];//whether a node is currently inside of my graph
        int num_of_disjointset = 0;

        for (int i = 0; i < N; i++) {
            int node_to_add = reverse_close_node[i];
            num_of_disjointset++;

            //add a new edge
            visited[node_to_add] = true;

            for (Integer adj_n : adjList[node_to_add]) {
                if (visited[node_to_add] && visited[adj_n] && ds.find(node_to_add) != ds.find(adj_n)) {
                    ds.union_sets(node_to_add, adj_n);
                    num_of_disjointset--;
                }
            }

            isConnected[i] = num_of_disjointset == 1;
        }

        //reversely print out is Connected
        for (int i = N - 1; i >= 0; i--) {
            if (isConnected[i])
                pw.println("YES");
            else
                pw.println("NO");
        }

        pw.close();
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int size) {
        parent = new int[size + 1];
        parent[0] = -1;//we dont use parent[0]
        rank = new int[size+1];

        for (int i = 1; i <= size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //if dont use path compression, get time out
    //if use recursive path compression, get stackoverflow
    int find(int v) {
        if (v == parent[v]) //already reached the representitive
            return v;
        return parent[v] = find(parent[v]); //path compression important to avoid timeout
    }

    //always make a representitive after union
    void union_sets(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    void union_sets_ranking(int a, int b) {
        int a_root = find(a);
        int b_root = find(b);
        if (a_root != b_root){
            if (rank[a_root] < rank[b_root])
                parent[a_root] = parent[b_root];
            else if (rank[a_root] > rank[b_root])
                parent[b_root] = parent[a_root];
            else {
                parent[b_root] = parent[a_root];
                rank[a_root]++;
            }
        }
    }
}
