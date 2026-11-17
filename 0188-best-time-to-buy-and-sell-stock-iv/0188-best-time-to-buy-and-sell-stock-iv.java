class Solution {
    public int rec(int []prices,int i,int k,int [][]dp){
        if(k==0) return 0;
        if(i<=0 ) return 0;
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int dont=rec(prices,i-1,k,dp);
        int maxi=0;
        for(int j=i;j>=0;j--){
            int o=(prices[i]-prices[j])+rec(prices,j-1,k-1,dp);
         
          
            maxi=Math.max(maxi,o);
        }
        return dp[i][k]=Math.max(maxi,dont);
    }
    public int maxProfit(int k, int[] prices) {
        int [][]dp=new int[prices.length][k+1];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(prices,prices.length-1,k,dp);
        
    }
}