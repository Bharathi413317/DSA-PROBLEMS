class Solution {
    public boolean isPerfectSquare(int num) {
        long l=1;
        long r=num;
        while(l<=r){
            long mid=l+(r-l)/2;
            long k=mid*mid;
            if(k==num){
                return true;
            }else if(k>num){
                r=mid-1;            }
        else{
            l=mid+1;
        }
        }return false;
    }
}
