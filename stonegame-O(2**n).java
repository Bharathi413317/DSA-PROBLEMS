class Solution {
    int solve(int[] piles,int i,int j){
        if(i==j){
            return piles[i];
        }int left=piles[i]-solve(piles,i+1,j);
        int right=piles[j]-solve(piles,i,j-1);
        return Math.max(left,right);
    }
    public boolean stoneGame(int[] piles) {
        return solve(piles,0,piles.length-1)>0;
    }
}
