class Solution {
    public int sumCounts(List<Integer> nums) {
        int count=0;
        for(int i=0;i<nums.size();i++){
            HashMap<Integer,Integer>hm=new HashMap<>();
                for(int j=i;j<nums.size();j++){
                    hm.put(nums.get(j),hm.getOrDefault(nums.get(j),0)+1);
                    count+=(int)Math.pow(hm.size(),2);
                    
                }
                
            }
        return count;
    }
}