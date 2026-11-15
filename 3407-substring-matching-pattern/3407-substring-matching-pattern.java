class Solution {
    public boolean hasMatch(String s, String p) {
        int k=-1;
       for(int i=0;i<p.length();i++){
        char ch=p.charAt(i);
        if (ch == '*'){
               k=i;
        }
       }
       String sub1=p.substring(0,k);
       String sub2=p.substring(k+1,p.length());
       int index=s.indexOf(sub1);
       if(index==-1) return false;
       return s.indexOf(sub2,index+sub1.length())!=-1;
    }
}