class Solution {
    public int reverseDegree(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            int ch=(int)Math.abs(s.charAt(i)-'z')+1;
            System.out.println((int)Math.abs(s.charAt(i)-'a'));
            count+=(i+1)*(ch);

        }
        
        return count;
    }
}