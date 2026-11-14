class Solution {
    public int min(int a,int b,int c){
        int min=a;
        if(b<min) min=b;
        if(c<min) min=c;
        return min;
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                       dp[i][j]=dp[i-1][j-1];
                  }else{
                    dp[i][j]=1+min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
                  }
            }
        }return dp[m][n];
    }
}       