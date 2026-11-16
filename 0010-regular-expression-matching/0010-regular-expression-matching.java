class Solution {
    public boolean rec(String s,String p,int i,int j){
        if(i==s.length() && j==p.length()){
            return true;
        }if(j==p.length()){
            return false;
        }
        if(i==s.length()){
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                  return rec(s,p,i,j+2);
            }
            return false;
        }
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean cons=(p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)) ? rec(s,p,i+1,j):false;
            boolean notcons=rec(s,p,i,j+2);
            
            return cons||notcons;

        }
        if(p.charAt(j)=='.'){
            return rec(s,p,i+1,j+1);
        }
        if(s.charAt(i)==p.charAt(j)){
            return rec(s,p,i+1,j+1);
        }
        return false;

    }
    public boolean isMatch(String s, String p) {
        return rec(s,p,0,0);
        
    }
}