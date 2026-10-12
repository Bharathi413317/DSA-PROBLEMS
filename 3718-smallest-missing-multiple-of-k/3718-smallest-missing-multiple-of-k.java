class Solution {
    public int missingMultiple(int[] nums, int k) {
         HashMap<Integer,Integer>hm=new HashMap<>();
         for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
         }int min=Integer.MAX_VALUE;
         for(int i=1;i<=1000;i++){
               int num=k*i;
               if(!hm.containsKey(num)){
                min=Math.min(min,num);
               }
         } return min;
    }
}