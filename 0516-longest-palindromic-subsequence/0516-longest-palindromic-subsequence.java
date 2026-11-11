class Solution {
    public int rec(String s,int sp,int ep,int [][]dp){
        if(sp==ep) return 1;
        if(sp+1==ep){
            if(s.charAt(sp)==s.charAt(ep)){
                return 2;
            }
            return 1;
        }
        if(dp[sp][ep]==-1){
        if(s.charAt(sp)==s.charAt(ep)){
            return rec(s,sp+1,ep-1,dp)+2;
        }
        int op1=rec(s,sp+1,ep,dp);
        int op2=rec(s,sp,ep-1,dp);
        dp[sp][ep]= Math.max(op1,op2);
        }
        return dp[sp][ep];
    }

    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int [][]dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(s,0,s.length()-1,dp);
        
    }
}