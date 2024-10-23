class Solution {
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int distance[]=new int[V];
        for(int i=0;i<V;i++){
            distance[i]=(int)1e8;
        }
        distance[src]=0;
        // O(V*E)
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> it : edges){
                int u=it.get(0);
                int v=it.get(1);
                int wt=it.get(2);
                
                if(distance[u]!=(int)1e8 && distance[u]+wt<distance[v]){
                    distance[v]=distance[u]+wt;
                }
                
            }
        }
        
         for(ArrayList<Integer> it : edges){
                int u=it.get(0);
                int v=it.get(1);
                int wt=it.get(2);
                
                if(distance[u]!=(int)1e8 && distance[u]+wt<distance[v]){
                    return new int[]{-1};
                }
                
            }
        
        return distance;
    }
}