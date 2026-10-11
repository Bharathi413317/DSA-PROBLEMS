class Solution {
    boolean b=false;
    public void dfs(List<List<Integer>>grid,int row,int col,int [][]vis,int health){
          int m = grid.size();
            int n = grid.get(0).size();
              if (b) return;
            if(row<0 ||row>=m || col<0 || col>=n || health<=0 || vis[row][col]>=health ){
                return;
            }
            health-=grid.get(row).get(col);
              if(health<=0 )return ;
            if(row==m-1 && col==n-1){
                b=true;
                return;
            }if (vis[row][col] >= health) return;
          
            vis[row][col]=health;
            
        int []drow={-1,0,1,0};
        int []dcol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow= row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                dfs(grid,nrow,ncol,vis,health);
            }

        }
        
        }
    
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
            int m = grid.size();
            int n = grid.get(0).size();
            int r=0;
            int c=0;
            int vis[][]=new int[m][n];
            dfs(grid,0,0,vis,health);

        return b;
    }
}