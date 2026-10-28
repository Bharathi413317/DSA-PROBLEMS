class Solution {
    public int rec(int [][] grid,int i,int j,int [][]dp){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 ||j<0||i==m || j==n) return Integer.MAX_VALUE;
        if(dp[i][j]==0){
        int r=rec(grid,i,j+1,dp);
        int d=rec(grid,i+1,j,dp);
            dp[i][j]= Math.min(r,d)+grid[i][j];
        }

        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int [][]dp=new int[grid.length][grid[0].length];
        return rec(grid,0,0,dp);
        
    }
}