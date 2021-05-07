package silver.Bipartite;

import java.util.LinkedList;
import java.util.Queue;

public class DetermineBipartite {
    public static void main(String[] args) {
        int[][] aGraph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(aGraph));
    }

    public static boolean isBipartite(int[][] graph) {
        int num_nodes = graph.length;
        int[] color = new int[num_nodes];
        for (int i=0; i<num_nodes; i++) color[i] = -1;
        for (int i=0; i<num_nodes; i++){
            if (color[i] == -1){
                if (!BFS(graph,i,color)) return false;
            }
        }
        return true;
    }

    public static boolean BFS(int[][] graph, int node, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] =0;
        int level = 1;


        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                Integer vtx = queue.poll();
                for (Integer neighbor : graph[vtx]) {
                    if (color[neighbor] == -1) {
                        queue.add(neighbor);
                        color[neighbor] = level % 2;
                    } else if (color[neighbor] == color[vtx]) {
                        return false;
                    }
                }
                size--;
            }
            level++;
        }
        return true;
    }
}
