
class Pair{
    String word;
    int steps;
    Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>hs=new HashSet<String>();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        //hs.remove(beginWord);
        int ans=0;
        while(!q.isEmpty()){
            String word=q.peek().word;
            int steps=q.peek().steps;
            q.remove();
             if(word.equals(endWord)){
                        ans= steps;
                        }
                   
          StringBuilder sb=new StringBuilder(word);
            for(int i=0;i<word.length();i++){
                    StringBuilder sb1=new StringBuilder(sb);
                for(int j=0;j<26;j++){
                   
                   sb1.setCharAt(i,(char)(j+'a'));
                 
                
        
                   if(hs.contains(sb1.toString())){
                    q.add(new Pair(sb1.toString(),steps+1));
                    hs.remove(sb1.toString());
                   
                }

            }
        }
        }return ans;

        
    }
}