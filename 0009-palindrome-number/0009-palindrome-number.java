class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        int rem=0;
        int num=0;
        while(x>0){
            rem=x%10;
            num=num*10+rem;
            x=x/10;

        }
        if(n==num){
            return true;
        }
        return false;
    }
}