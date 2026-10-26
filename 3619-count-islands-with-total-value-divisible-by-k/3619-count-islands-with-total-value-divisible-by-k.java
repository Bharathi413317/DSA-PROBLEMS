class Solution {
    
    public long dfs(int [][]grid,int [][]vis,int target,int row,int col){
        vis[row][col]=1;
        long sum=grid[row][col];
        int []drow={1,0,-1,0};
        int []dcol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]>0 && vis[nrow][ncol]==0){
                sum+=dfs(grid,vis,target,nrow,ncol);
              }
         }
        return sum;
        

    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]vis=new int [m][n];
        int count=0;
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){
                
                if(grid[i][j]>0 && vis[i][j]==0){
                long sum=dfs(grid,vis,k,i,j);
                   
                    if(sum%k==0){
                    count++;
                    }
                }
                }
            }
        
        return count;
    }
}