class Solution {
    public int missingInteger(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }int sum=0;
        int l=0;
        sum+=nums[0];
        if(nums.length==1) return sum+1;
        if(nums[1]!=nums[0]+1){
             while(hm.containsKey(sum)) {
                    sum+=1;
               }return sum;
        }
        for(int i=1;i<nums.length;i++){
            
               if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
               }
               else{
                while(hm.containsKey(sum)) {
                    sum+=1;
               }l=Math.max(l,sum);
               sum=0;
            }if(i==nums.length-1){
               l=Math.max(l,sum); 
            }
        }return l;
    }
}
