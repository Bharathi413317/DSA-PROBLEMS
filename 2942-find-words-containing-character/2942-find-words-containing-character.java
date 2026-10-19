class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer>lst=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            HashMap<Character,Integer>hm=new HashMap<>();
            for(int j=0;j<words[i].length();j++){
                         char ch=words[i].charAt(j);
                         hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
            if(hm.containsKey(x)){
                lst.add(i);
            }
        }return lst;
    }
}