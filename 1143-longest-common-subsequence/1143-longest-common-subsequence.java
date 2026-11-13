class Solution {
    public int rec(String text1,String text2,int i,int j,int [][]dp){
        if(i==text1.length() || j==text2.length()) return 0;
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+rec(text1,text2,i+1,j+1,dp);
        }
        if(dp[i][j]==-1){
        int inc=rec(text1,text2,i+1,j,dp);
        int exc=rec(text1,text2,i,j+1,dp);
        dp[i][j]= Math.max(inc,exc);
        }return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
      
        return rec(text1,text2,0,0,dp);
    }
}