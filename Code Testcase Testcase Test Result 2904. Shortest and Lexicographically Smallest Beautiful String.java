class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
      int n=s.length();
      int [] ones=new int[n];
      int count=0;
      for(int i=0;i<n;i++){
               if(s.charAt(i)=='1'){
                ones[count]=i;
                count++;
               }
      }
      if(count<k){
        return "";
      }
      String str="";
      for(int i=0;i+k-1<count;i++){
        int left=ones[i];
        int right=ones[i+k-1];
        String curr=s.substring(left,right+1);
        if(curr.length()<str.length() || str.equals("")||(curr.length() == str.length()
                        && curr.compareTo(str) < 0)){
                            str=curr;
                        }
      }return str;
    }
}
