class Solution {
    public void dfs(int node,List<List<Integer>>adj,int []vis,Stack<Integer>st){
        vis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
            
        }st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer>lst=new ArrayList<>();
           adj.add(lst);
           
            
        }for(int i=0;i<edges.length;i++){
             adj.get(edges[i][0]).add(edges[i][1]);
        }
        int []vis=new int[V];
         Stack<Integer>st=new Stack<Integer>();
         for(int i=0;i<V;i++){
             if(vis[i]==0){
                 dfs(i,adj,vis,st);
             }
         }
         ArrayList<Integer>a=new ArrayList<>();
         while(!st.isEmpty()){
             int k=st.peek();
             a.add(k);
             st.pop();
             
         }return a;
         
        
    }
}
