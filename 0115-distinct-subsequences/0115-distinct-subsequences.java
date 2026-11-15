class Solution {
public int rec(String s,String t,int i,int j,int [][]dp){
       if(t.length()==j) return 1;
       if(s.length()==i) return 0;
       int inc=0;
       if(dp[i][j]!=-1){
        return dp[i][j];
       }
       if(s.charAt(i)==t.charAt(j)){
          inc=rec(s,t,i+1,j+1,dp);
       }
       int exc=rec(s,t,i+1,j,dp);
       return dp[i][j]=inc+exc;
} public int numDistinct(String s, String t) {
        int [][]dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }

        return rec(s,t,0,0,dp);
    }
}