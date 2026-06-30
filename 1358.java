//brute
class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
             for(int i=0;i<s.length();i++){
                   HashMap<Character,Integer>hm=new HashMap<>();
                  for(int j=i;j<s.length();j++){
                     char ch=s.charAt(j);
                     hm.put(ch,hm.getOrDefault(ch,0)+1);
                  if(hm.containsKey('a') && hm.containsKey('b') && hm.containsKey('c')){
                    count++;
                  }
                  }
             }return count;
    }
}
