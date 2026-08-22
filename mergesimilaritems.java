class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
      
     
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int [] item:items1){
            hm.put(item[0],hm.getOrDefault(item[0],0)+item[1]);
        }for(int [] item:items2){
            hm.put(item[0],hm.getOrDefault(item[0],0)+item[1]);
        } List<Integer> keys = new ArrayList<>(hm.keySet());
          List<List<Integer>>ans=new ArrayList<>();
        Collections.sort(keys);
        for(int key:keys){
             List<Integer> temp = new ArrayList<>();
             temp.add(key);
             temp.add(hm.get(key));
             ans.add(temp);

        }return ans;
    }
}
