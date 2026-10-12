class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
    
    
}

class Solution {
    public void dfs(List<ArrayList<Pair>>adj,int []vis,int node,Stack<Integer>st){
        vis[node]=1;
        for(Pair p: adj.get(node)){
            int vetx=p.first;
            if(vis[vetx]==0){
                dfs(adj,vis,vetx,st);
            }
        }st.push(node);
        
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
       List<ArrayList<Pair>>list=new ArrayList<>();
       for(int i=0;i<V;i++){
           list.add(new ArrayList<Pair>());
       }
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           int wt=edges[i][2];
           list.get(u).add(new Pair(v,wt));
       }int []vis=new int [V];
       Stack<Integer>st=new Stack<>();
       for(int i=0;i<V;i++){
           if(vis[i]==0){
               dfs(list,vis,i,st);
           }
       }
       int []dist=new int[V];
       for(int i=0;i<V;i++){
           dist[i]=Integer.MAX_VALUE;
       }dist[0]=0;
       while(!st.isEmpty()){
           int k=st.pop();
           for(Pair h:list.get(k)){
               int wtt=h.second;
               int vers=h.first;
               if(dist[k]!=Integer.MAX_VALUE && dist[k]+wtt<dist[vers]){
                   dist[vers]= dist[k]+wtt;
               }
           }
       }for(int i=0;i<V;i++){
           if(dist[i]== Integer.MAX_VALUE){
               dist[i]=-1;
           }
           
       }ArrayList<Integer>m=new ArrayList<>();
       for(int i=0;i<dist.length;i++){
           m.add(dist[i]);
       }
       return m;
       
       
        
    }
}
