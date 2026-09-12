class Solution {
    public int mySqrt(int x) {
        int left=0,right=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            long k=(long)mid*mid;
            if(k==x){
                return mid;
            }else if(k<x){
                  left=mid+1;
            }else{
                right=mid-1;
            }
        }return right;
}
}
