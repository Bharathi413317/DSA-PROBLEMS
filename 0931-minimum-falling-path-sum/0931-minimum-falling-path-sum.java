class Solution {
   public int rec(int [][]matrix,int r,int c,int [][]dp){
     if(r<0 || c<0 || r>matrix.length-1 || c>=matrix[0].length){
                return Integer.MAX_VALUE;
            }
            if(r==matrix.length-1){
                return matrix[r][c];
            }
            if(dp[r][c]!=-980){
                return dp[r][c];
            }
            int a=rec(matrix,r+1,c-1,dp);
            int b=rec(matrix,r+1,c,dp);
            int d=rec(matrix,r+1,c+1,dp);
             dp[r][c]=matrix[r][c]+Math.min(a,Math.min(b,d));
            
            
            return  dp[r][c];
   }

    public int minFallingPathSum(int[][] matrix) {
         int cost=Integer.MAX_VALUE;
        int [][]dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            
                Arrays.fill(dp[i],-980);
            
        }
       for(int i=0;i<matrix[0].length;i++){
       cost=Math.min(cost, rec(matrix,0,i,dp));

       }
       return cost;
        
    }
}