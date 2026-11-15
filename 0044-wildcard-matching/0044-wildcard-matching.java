class Solution {
    public boolean rec(String s,String p,int i,int j,int [][]dp){
        if(s.length()==i && p.length()==j){
            return true;
        }if(p.length()==j && s.length()!=i){
            return false;
        }if(s.length()==i){
            if(p.charAt(j)!='*'){
                return false;
            }
            return rec(s,p,i,j+1,dp);
        }if(dp[i][j]!=0){
            if(dp[i][j]==1)   dp[i][j]=rec(s,p,i+1,j+1,dp)? 1:-1;
             return dp[i][j]==1;
        }
        if(p.charAt(j)=='?'){
             dp[i][j]=rec(s,p,i+1,j+1,dp)? 1:-1;
             return dp[i][j]==1;
        }else if(p.charAt(j)=='*'){
            boolean emp=rec(s,p,i,j+1,dp);
            boolean nonemp=rec(s,p,i+1,j,dp);
             dp[i][j]= emp||nonemp ? 1:-1;
             return dp[i][j]==1;
        }if(s.charAt(i)!=p.charAt(j)){
            return false;
        }
        dp[i][j]=rec(s,p,i+1,j+1,dp)? 1:-1;
        return dp[i][j]==1;
    }
    public boolean isMatch(String s, String p) {
        int [][]dp=new int[s.length()][p.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],0);
        }
        return rec(s,p,0,0,dp);
    }
}