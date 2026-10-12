class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        int V=numCourses;
        int []ind=new int[V];
        for(int i=0;i<V;i++){
            List<Integer>lst=new ArrayList<>();
            adj.add(lst);
        }
        
        for(int []p:prerequisites){
            adj.get(p[1]).add(p[0]);
        }
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                ind[it]++;
            }
        }Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
           
                if(ind[i]==0){
                    q.add(i);
                }
            
        }int cnt=0;
        int []topo=new int[V];
        while(!q.isEmpty()){
            int k=q.peek();
            q.remove();
            topo[cnt++]=k;
            
                for(int it:adj.get(k)){
                    ind[it]--;
                    if(ind[it]==0){
                        q.add(it);
                    }
                }
            

        }if(cnt==V){
            return topo;
        }
        int []a={};
        return a;

    }
}