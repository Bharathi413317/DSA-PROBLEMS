class Solution {
    public boolean bfs(int row,int []vis,int []color,int [][]graph){
        vis[row]=1;
        color[row]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(row);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               int n=q.poll();
               for(int j=0;j<graph[n].length;j++){
                int num=graph[n][j];
                if(vis[num]==0){
                    if(color[n]==0){
                        vis[num]=1;
                        color[num]=1;
                        q.add(num);
                    }else{
                        vis[num]=1;
                        color[num]=0;
                        q.add(num);
                    }
                }else{
                    if(color[n]==color[num]){
                         return false;
                    }

                }
               }
            }
            }return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int []vis=new int[graph.length];
        int []color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                if(!bfs(i,vis,color,graph)){
                    return false;
                }
            }
        }return true;
        
    }
}