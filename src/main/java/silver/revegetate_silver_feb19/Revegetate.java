/*
* "2SAT" problem --- setting variables in a boolean expression
* like (x OR y) AND (not(x) OR y) AND (z OR not(y)) to either true
* or false so the entire expression evaluates to true.
*
* so here "S" and "D" is same, you just need to union them into a set
* then count the number of disjoint set, the answer is 2^setNum
* to write in binar is 100...setnumber of zero...000
* */

//package silver.revegetate_silver_feb19;

import java.util.*;
import java.io.*;

public class Revegetate {
    public static void main(String[] args) throws Exception{
        // Read the grid.
        Scanner stdin = new Scanner(new File("revegetate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        int N = stdin.nextInt();
        int M = stdin.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<N+1; i++) adjList.add(new ArrayList<Integer>());
        for (int i=0; i<M; i++){
            String str = stdin.next();//useless?
            int node1 = stdin.nextInt();
            int node2 = stdin.nextInt();
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        DisjointSet_revegetate djs = new DisjointSet_revegetate(N);
        //union all adjacent nodes
        for (int node=1; node<N+1; node++){
            for (Integer neighbor: adjList.get(node)){
                djs.union(node,neighbor);
            }
        }

        // 2 to the power of djs.setNum ways
        //to binary
        pw.print(1);
        for(int i=0; i<djs.setNum; i++)
            pw.print(0);

        pw.close();
    }

}

class DisjointSet_revegetate{
    int[] par;
    int setNum;
    DisjointSet_revegetate(int numNode){
        par = new int[numNode+1];
        for (int i=0; i<numNode+1; i++){
            par[i] = i;
        }
        setNum = numNode;
    }

    //查找x集合的代表节点，同时并查集 path compression
    int find(int x){
        if (x == par[x]){
            return x;
        }else {
            par[x] = find(par[x]);
            return par[x];
        }
    }

    void union(int x, int y){
        int x_root = find(x);
        int y_root = find(y);
        if(x_root != y_root){
            par[y_root] = x_root;
            setNum--;
        }
    }
}
