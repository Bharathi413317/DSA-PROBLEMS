class Solution {
    public int kthDigit(long k) {
       if(k<=9){
           return (int)k;
       }k-=9;
        long block=1;
        while(true){
            long start=block*10;
            int digits=Long.toString(start).length();
            long totaldigits=10L*digits;
            while(k<=totaldigits){
                long numberindex=(k-1)/digits;
                int digitindex=(int)(k-1)%digits;
                long number;
                if(block%2==0){
                    number=start+numberindex;
                }else{
                    number=start+9-numberindex;
                }
                String s=Long.toString(number);
                return s.charAt(digitindex)-'0';
            }k-=totaldigits;
            block++;
        }
        
    }
}
