class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashMap<Integer,Integer>hm1=new HashMap<>();
        HashMap<Integer,Integer>hm2=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=1000;i++){
                int m=k*i;
                hm2.put(m,hm2.getOrDefault(m,0)+1);
        }for(int num:nums){
            hm1.put(num,hm1.getOrDefault(num,0)+1);
        }for(int key:hm2.keySet()){
            if(!hm1.containsKey(key)){
                  min=Math.min(min,key);   
            }
        }return min;
    }
}
