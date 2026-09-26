class Solution {
    public boolean dfs(int node,int [][]graph,int []vis,int []pathvis,int []check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfs(it,graph,vis,pathvis,check)==true){
                    return true;
                }
            }else if(pathvis[it]==1){
                   return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int vis[]=new int [V];
        int  []pathvis=new int[V];
        int []check=new int[V];
        List<Integer>safenodes=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathvis,check);
            }
        }  for(int i=0;i<V;i++){
            if(check[i]==1){
                safenodes.add(i);
            }
        }
        return safenodes; 
    }
}