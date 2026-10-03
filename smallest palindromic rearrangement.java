class Solution {
    public String smallestPalindrome(String s) {
        int []freq=new int[26];
        for(char ch: s.toCharArray()){
              freq[ch-'a']++;
           }
           StringBuilder left=new StringBuilder();
           char middile=' ';
           for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                middile=(char)(i+'a');
            }int count=freq[i]/2;
            while(count>0){
                left.append((char)(i+'a'));
                count--;
            }
           }
            String right=left.reverse().toString();

           StringBuilder sb=new StringBuilder();
           sb.append(left.reverse());
           if(middile!=' '){
            sb.append(middile);
           }sb.append(right);
        return sb.toString();
    } 
}
