class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []p:prerequisites){
            adj.get(p[1]).add(p[0]);
        }
        int []indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        } int cnt=0;
        while(!q.isEmpty()){
            int k=q.peek();

            q.remove();
            cnt++;
            for(int it:adj.get(k)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
            if(indegree[k]==0){

            }
        }if(cnt==numCourses) return true;
        return false;



    }
}