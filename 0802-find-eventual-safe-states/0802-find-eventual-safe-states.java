class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         List<List<Integer>>lst=new ArrayList<>();
         int V=graph.length;
         int []indegree=new int[V];
         for(int i=0;i<V;i++){
            lst.add(new ArrayList<>());
         }
         for(int i=0;i<graph.length;i++){
            for(int it:graph[i]){
                 lst.get(it).add(i);
                 indegree[i]++;

            }
         }Queue<Integer>q=new LinkedList<>();
         for(int i=0;i<V;i++){
                  if(indegree[i]==0){
                    q.add(i);
                  }
         }List<Integer>l=new ArrayList<>();
         while(!q.isEmpty()){
            int k=q.peek();
           
            q.remove();
             l.add(k);
            for(int it:lst.get(k)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }


         }
         Collections.sort(l);
         return l;

    }
}