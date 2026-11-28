class Solution {
    public int rec(List<List<Integer>>triangle,int ind,int ln,int [][]dp){
        int n=triangle.size();
          if(n-1==ln){
            return triangle.get(ln).get(ind);
          }
          if(dp[ln][ind]!=-908){
            return dp[ln][ind];
          }
        int a=rec(triangle,ind,ln+1,dp);
        int b=rec(triangle,ind+1,ln+1,dp);
        dp[ln][ind]= triangle.get(ln).get(ind)+Math.min(a,b);
           return dp[ln][ind];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
           int n=triangle.size();
        int [][]dp= new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-908);
        }
        return rec(triangle,0,0,dp);

        
    }
}