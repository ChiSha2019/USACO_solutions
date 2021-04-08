package Disjoint_set_union;

public class detect_cycle {
    public static void main(String[] args) {
        Edge[] edgeList = {new Edge(1,2), new Edge(2,3),new Edge(3,4),new Edge(4,5), new Edge(2,5), new Edge(1,6)};

        DisjointSet ds = new DisjointSet(6);

        for (Edge e: edgeList){
            //check if the 2 nodes of this edge are already in a same set
            if(ds.find(e.node1) == ds.find(e.node2)){
                System.out.println("cycle detected with edge:  " + e.node1 + e.node2);
                return;
            }else {
                ds.union_sets(e.node1, e.node2);
            }
        }
    }
}
class Edge{
    Edge(int n1, int n2){
        node1 = n1;
        node2 = n2;
    }
    int node1;
    int node2;
}

class DisjointSet{
    int[] parent;
    DisjointSet(int size){
        parent = new int[size+1];
        for (int i=1;i<=size;i++)
            parent[i] = i;
    }

    int find(int v){
        if (v == parent[v]) //already reached the reprsentitive
            return v;
        return find(parent[v]);
    }

    void union_sets(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

}