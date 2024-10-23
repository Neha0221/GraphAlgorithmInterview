class Solution {
    public void floydWarshall(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        // O(n^2*m)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=(int)1e9;
                }
                
                if(i==j){
                    mat[i][j]=0;
                }
            }
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==(int)1e9){
                    mat[i][j]=-1;
                }
            }
        }
    }
}