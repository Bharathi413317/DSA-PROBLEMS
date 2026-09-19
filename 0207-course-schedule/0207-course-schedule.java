class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

      
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {

                if (dfs(i, adj, vis, pathVis)) {
                    return false; 
                }
            }
        }

        return true; 
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        int[] vis,
                        int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int next : adj.get(node)) {

            if (vis[next] == 0) {

                if (dfs(next, adj, vis, pathVis)) {
                    return true;
                }
            }
            else if (pathVis[next] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;

        return false;
    }
}