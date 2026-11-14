class Solution {
    public int rec(String word1,String word2,int i,int j,int [][]dp){
       if(i<0) return j+1;
       if(j<0) return i+1;

        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]= rec(word1,word2,i-1,j-1,dp);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int rep=1+rec(word1,word2,i-1,j-1,dp);
        int ins=1+rec(word1,word2,i-1,j,dp);
        int del=1+rec(word1,word2,i,j-1,dp);

        return dp[i][j]=Math.min(rep,Math.min(ins,del));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(word1,word2,m-1,n-1,dp);
        
    }
}       