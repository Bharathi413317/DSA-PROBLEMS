class Solution {
    public int countSpecialIntegers(int[] nums) {
       HashMap<Integer,Boolean>hm=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int num=nums[i];
        if(!hm.containsKey(num)){
            hm.put(num,true);
        }else{
            if(nums[i-1]!=nums[i]){
                hm.put(num,false);
            }
        }

       }int count=0;
       for(boolean value:hm.values()){
                if(value==true){
                    count+=1;
                }
       }return count;
    }
}