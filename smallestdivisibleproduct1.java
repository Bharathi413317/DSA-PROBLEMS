class Solution {
    public boolean isdivisible(int n,int t){
        int p=1;
        while(n>1){
            int rem=n%10;
            n=n/10;
            p*=rem;
        }if(p%t==0) return true;
    return false;

    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(isdivisible(i,t)){
                return i;
            }
        }return -1;
    }
}
