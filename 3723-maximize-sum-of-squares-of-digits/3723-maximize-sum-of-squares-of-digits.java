class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
        if(sum>9*num){
            return "";
        }
        int countnines=sum/9;
        int rem=sum%9;
        while(countnines>0){
            sb.append('9');
            countnines--;
        }if(rem>0) sb.append(rem);
        while(sb.length()!=num){
            sb.append('0');
        }
        return sb.toString();
    }           
}