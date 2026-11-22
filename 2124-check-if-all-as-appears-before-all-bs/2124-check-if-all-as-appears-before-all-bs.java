class Solution {
    public boolean checkString(String s) {
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            char c2=s.charAt(i-1);
            if(ch=='a' && c2=='b'){
                 return false;
            }
        }return true;
        
    }
}