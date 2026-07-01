class Solution {
    public String sortString(String s) {
        int []freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }StringBuilder ans=new StringBuilder();
        while(ans.length()<s.length()){
            for(int i=0;i<26;i++){
                if(freq[i]>0){
                    ans.append((char)(i+'a'));
                    freq[i]--;
                }
            }for(int j=25;j>=0;j--){
                if(freq[j]>0){
                    ans.append((char)(j+'a'));
                    freq[j]--;
                }
            }
        }return ans.toString();
    }
}
