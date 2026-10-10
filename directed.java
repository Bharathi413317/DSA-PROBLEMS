class Solution {
    public boolean dfs(int node,int []vis,int []pathvis,List<List<Integer>>lst){
        vis[node]=1;
        pathvis[node]=1;
        for(int it:lst.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,pathvis,lst)==true){
                    return true;
                }
            }else if(pathvis[it]==1){
                return true;
            }
            
        }pathvis[node]=0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> lst=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer>l=new ArrayList<>();
              lst.add(l);
        }
        for(int j=0;j<edges.length;j++){
            lst.get(edges[j][0]).add(edges[j][1]);
        }
        int []vis=new int[V];
        int []pathvis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathvis,lst)){
                    return true;
                }
            }
        }return false;
        
    }
}
