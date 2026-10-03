class Solution {
    public boolean dfs(int node,int col,int [][]graph,int []color){
        color[node]=col;
                for(int i: graph[node]){
                if(color[i]==-1){
                    if(dfs(i,1-col,graph,color)==false) return false;
                }
                else if(color[i]==col){
                    return false;
                }
            }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []color=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,graph,color)==false){
                    return false;
                }
            }
        }return true;
        
    }
}