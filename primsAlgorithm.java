class Pair{
    int node;
    int wt;
    public Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    static int primsAlgorithm(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.wt - b.wt);
        boolean visited[]=new boolean[V];
        Arrays.fill(visited,false);
        int sum=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int currNode=pq.peek().node;
            int currWeight=pq.peek().wt;
            pq.poll();
            
            if(visited[currNode]==true) continue;
            
            else{
                sum+=currWeight;
                visited[currNode]=true;
            } 
            
            for(int[] it : adj.get(currNode)){
                int adjNode=it[0];
                int adjWeight=it[1];
                
                if(visited[adjNode]==false){
                    pq.add(new Pair(adjNode,adjWeight));
                }
                
            }
        }
        
        return sum;
        
    }
}