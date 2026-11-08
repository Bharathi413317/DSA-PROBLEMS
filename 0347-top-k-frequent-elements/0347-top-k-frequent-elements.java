

class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>arr=new ArrayList<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int num:nums){
              hm.put(num,hm.getOrDefault(num,0)+1);
        }
        while(k!=0){
            int max=Integer.MIN_VALUE;
            int ke=0;
            for(int key:hm.keySet()){
                   if(hm.get(key)>max){
                    max=hm.get(key);
                    ke=key;
                   }

            }hm.remove(ke);
            arr.add(ke);
            k--;


        }
        return  arr.stream().mapToInt(Integer::intValue).toArray();
    }

}
