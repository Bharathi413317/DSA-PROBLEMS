class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder ans=new StringBuilder();
        for(char c:s.toCharArray()){
            ans.append(
                String.format(
                    "%8s",Integer.toBinaryString(c)).replace(' ','0'));
        }int l=0;
        int r=ans.length()-1;
        while(l<r){
            if(ans.charAt(l)!=ans.charAt(r)){
                return false;
            }
            l++;
            r--;
        }return true;
    }
}
