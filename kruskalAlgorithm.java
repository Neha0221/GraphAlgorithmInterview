import java.util.*;

class Edge{
    int src;
    int dest;
    int weight;
    public Edge(int src,int dest,int weight){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
}
class kruskalAlgorithm{
    public static int findUParent(int node,int parent[]){
        if(node==parent[node]) return node;
        return parent[node]=findUParent(parent[node],parent);
    }

    public static void union(int u,int v,int parent[],int rank[]){
        int rootU=findUParent(u,parent);
        int rootV=findUParent(v,parent);
        if(rootU!=rootV){
            if(rank[rootU]>rank[rootV]){
                parent[rootV]=rootU;
            }
            else if(rank[rootU]<rank[rootV]){
                parent[rootU]=rootV;
            }
            else{
                parent[rootU]=rootV;
                rank[rootV]++;

            }
        }
    }

    public static int kruskalMST(int V,ArrayList<Edge> edges){
        // O(ElogE)
        Collections.sort(edges,(a,b)-> a.weight - b.weight);

        int rank[]=new int[V];
        int parent[]=new int[V];

        for(int i=0;i<V;i++){
            rank[i]=0;
            parent[i]=i;
        }

        int miniEdgeWeight=0;
        int edgeCnt=0;
        for(Edge it : edges){
            int u=it.src;
            int v=it.dest;

            if(findUParent(u,parent)!=findUParent(v,parent)){
                union(u,v,parent,rank);
                miniEdgeWeight+=it.weight;
                edgeCnt++;
            }

            if(edgeCnt==V-1) break;
        }

        return miniEdgeWeight;

    }


    public static void main(String[] args) { 
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int mstWeight = kruskalMST(V, edges);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}

// Time Complexity: O(N+E) + O(E logE) + O(E*4α*2)  
// Space Complexity: O(N) + O(N) + O(E) 