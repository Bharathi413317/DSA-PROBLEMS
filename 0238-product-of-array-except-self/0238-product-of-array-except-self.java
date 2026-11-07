
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []arr=new int[nums.length];
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int prod=1;
    
        for(int num:nums){
            if(num!=0){
            prod*=num;
            }
        }
       
        if(hm.containsKey(0)){
            
            for(int i=0;i<nums.length;i++){
                 if(nums[i]==0){
                    arr[i]=prod;
                 }else{
                    arr[i]=0;
                 }
            }
        
        }
        else{
            for(int i=0;i<nums.length;i++){
                arr[i]=prod/nums[i];
            }
        }
        if(hm.containsKey(0) && (hm.size()==1 ||hm.get(0)>1) ){
            System.out.println(hm.size());
            Arrays.fill(arr,0);
        }
        return arr;
    }
}