class Solution {
    public boolean rec(String s,String p,int i,int j,int [][]dp){
        if(i==s.length() && j==p.length()){
            return true;
        }if(j==p.length()){
            return false;
        }
        if(i==s.length()){
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                  return rec(s,p,i,j+2,dp);
            }
            return false;
        }
        if(dp[i][j]!=0){
            if(dp[i][j]==1) return true;
            return false;
        }
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean cons=(p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)) ? rec(s,p,i+1,j,dp):false;
            boolean notcons=rec(s,p,i,j+2,dp);
            
            dp[i][j]=cons||notcons ?1 :-1;
            return dp[i][j]==1?true:false;

        }
        if(p.charAt(j)=='.'){
            dp[i][j]=rec(s,p,i+1,j+1,dp) ?1 :-1;
             return dp[i][j]==1;
        }
        if(s.charAt(i)==p.charAt(j)){
            dp[i][j]=rec(s,p,i+1,j+1,dp)?1:-1;
             return dp[i][j]==1;
        }
        return false;

    }
    public boolean isMatch(String s, String p) {
        int [][]dp=new int[s.length()][p.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],0);
        }
        return rec(s,p,0,0,dp);
        
    }
}