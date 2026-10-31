
class Solution {
   int mod=1000000007;
   public int rec(int [][]grid,int row,int col,int dir,int [][][]dp){
    int m=grid.length;
    int n=grid[0].length;
    if(row<0 ||row>=m ||col<0 ||col>=n){
        return 0;
    }if(row == m-1 && col==n-1){
        return 1;
    }
    int k=0;
    if(dp[row][col][dir]==-1){
    if(grid[row][col]==1){
        if(dir==0){
            k+=rec(grid,row+1,col,1,dp);
        }else{
            k+=rec(grid,row,col+1,0,dp);
        }
    }else{
        k+=rec(grid,row+1,col,1,dp);
        k+=rec(grid,row,col+1,0,dp);
    
    }dp[row][col][dir]=k;
    }
    return dp[row][col][dir]%mod;
   }
    public int uniquePaths(int[][] grid) {
        int [][][]dp=new int[grid.length][grid[0].length][2];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                    Arrays.fill(dp[i][j],-1);
            }
        }
        return rec(grid,0,0,0,dp)%mod;
        
    }
}
