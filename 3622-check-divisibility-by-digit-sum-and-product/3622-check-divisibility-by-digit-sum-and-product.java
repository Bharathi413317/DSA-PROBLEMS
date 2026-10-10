class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int k=n;
        while(n>0){
            int rem=n%10;
            sum+=rem;
            prod*=rem;
            n=n/10;
            }
        return k%(sum+prod)==0;
    }
}