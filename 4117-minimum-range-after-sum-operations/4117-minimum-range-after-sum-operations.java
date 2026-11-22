class Solution {
    public int minRange(int a, int b, int c) {
        int minrange=Math.max(a,Math.max(b,c))-Math.min(a,Math.min(b,c));
        if(a>b && a>c){
            a=b+c;
        }else if(b>c && b>a){
            b= a+c;
        }else{
            c=a+b;
        }
        minrange=Math.min(minrange,Math.max(a,Math.max(b,c))-Math.min(a,Math.min(b,c)));

        return minrange;
        
        
    }
}