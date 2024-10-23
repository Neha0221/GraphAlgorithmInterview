import java.util.*;

class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class DijkstraAlgorithm {
    public int[] miniDistance(int n, ArrayList<ArrayList<Pair>> adj) {
        
        int shortestDistance[]=new int[n];
        Arrays.fill(shortestDistance,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.distance - b.distance);

        pq.add(new Pair(0,0));
        shortestDistance[0]=0;

        while(!pq.isEmpty()){
            int currNode=pq.peek().node;
            int currDistance=pq.peek().distance;
            pq.poll();


            for(Pair it : adj.get(currNode)){
                int adjNode=it.node;
                int edgeWeight=it.distance;

                if(currDistance+edgeWeight<shortestDistance[adjNode]){
                    shortestDistance[adjNode]=currDistance+edgeWeight;
                    pq.add(new Pair(adjNode,shortestDistance[adjNode]));
                }
            }
        }

        return shortestDistance;

    }

     public static void main(String[] args) {
        // Number of vertices (V)
        int V = 5;

        // Pre-built adjacency list (graph representation)
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Initialize adjacency list for each node
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Manually adding edges to the adjacency list
        adj.get(0).add(new Pair(1, 2)); // Edge 0 -> 1 (weight 2)
        adj.get(1).add(new Pair(0, 2)); // Edge 1 -> 0 (weight 2)

        adj.get(1).add(new Pair(2, 5)); // Edge 1 -> 2 (weight 5)
        adj.get(2).add(new Pair(1, 5)); // Edge 2 -> 1 (weight 5)

        adj.get(1).add(new Pair(3, 4)); // Edge 1 -> 3 (weight 4)
        adj.get(3).add(new Pair(1, 4)); // Edge 3 -> 1 (weight 4)

        adj.get(0).add(new Pair(3, 1)); // Edge 0 -> 3 (weight 1)
        adj.get(3).add(new Pair(0, 1)); // Edge 3 -> 0 (weight 1)

        adj.get(3).add(new Pair(2, 3)); // Edge 3 -> 2 (weight 3)
        adj.get(2).add(new Pair(3, 3)); // Edge 2 -> 3 (weight 3)

        adj.get(2).add(new Pair(4, 1)); // Edge 2 -> 4 (weight 1)
        adj.get(4).add(new Pair(2, 1)); // Edge 4 -> 2 (weight 1)

        // Create a DijkstraAlgorithm object and call miniDistance
        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        int distance[] = obj.miniDistance(V, adj);

        // Print shortest distances from node 0
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }
}

/*

Time complexity:
Extract-Min: Happens V times, each costing O(log V) → V * log V
Relaxing Edges: Happens E times, each costing O(log V) → E * log V
This gives the final time complexity as O((V + E) * log V), which is efficient for sparse graphs.


The space complexity of Dijkstra's algorithm depends on the following components:
Graph Representation (Adjacency List)
Distance Array
Priority Queue (Min-Heap)
*/
