class Solution {
    public boolean dfs(int [][]grid,int[][] vis,int row,int col){
       
        if(row==0 || row==grid.length-1 || col==0 || col==grid[0].length-1 ){
            return false;
        }
         vis[row][col]=1;
        int []drow={1,0,-1,0};
        int []dcol={0,1,0,-1};
        boolean closed=true;
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==0 && vis[nrow][ncol]==0){
                if(!dfs(grid,vis,nrow,ncol)){
                    closed=false;
                }
            }

        }
        return closed;

    }
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(vis[i][j]==0 && grid[i][j]==0){
                        if(dfs(grid,vis,i,j)){
                        count+=1;
                        }
                 } 
            }
        }return count;
    }
}