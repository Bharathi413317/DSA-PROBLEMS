class Solution {
    public int rec(String word1,String word2,int i,int j,int [][]dp){
        if(i==word1.length() && j==word2.length()){
            return 0;
        }
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]= rec(word1,word2,i+1,j+1,dp);
        }
        int od=1+rec(word1,word2,i+1,j,dp);
        int td=1+rec(word1,word2,i,j+1,dp);

        return dp[i][j]=Math.min(od,td);
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

          int [][]dp=new int[m][n];
          for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
          }
          return rec(word1,word2,0,0,dp);
    }
}