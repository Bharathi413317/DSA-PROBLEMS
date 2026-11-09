class Solution {
    public boolean rec(String s,int i,int j){
        if(i==j) return true;
        if(i>j) return true;
        if(s.charAt(i)!=s.charAt(j)) return false;
        return rec(s,i+1,j-1);
    }
  public int countSubstrings(String s) {
    int count=0;
    int n=s.length();
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            boolean ispali=rec(s,i,j);
            if(ispali) count++;
        }
    }return count;
        
    }
}