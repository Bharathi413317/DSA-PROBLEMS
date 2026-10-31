class Solution {
    public int rec(int[][] obstacleGrid,int row,int col,int [][]dp){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        if(row<0 || row>=m || col<0 || col>=n ){
                   return 0;
        }
        if(obstacleGrid[row][col] == 1){
    return 0;
}
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(dp[row][col]==-1){
       int right= rec(obstacleGrid,row,col+1,dp);
        int left=rec(obstacleGrid,row+1,col,dp);
        dp[row][col]=left+right;
        }return dp[row][col];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

           int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(obstacleGrid,0,0,dp);
        
    }
}