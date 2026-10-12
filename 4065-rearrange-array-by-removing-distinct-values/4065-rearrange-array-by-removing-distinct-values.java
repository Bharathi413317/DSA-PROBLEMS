class Solution {
    public int[] rearrangeArray(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int []arr=new int[nums.length];
        
                    int k=0;
       while(!hm.isEmpty()){
           ArrayList<Integer>list=new ArrayList<>(hm.keySet());
           Collections.sort(list);
           for(int key:list){
                arr[k++]=key;
                int count=hm.get(key)-1;
               if(count==0){
                   hm.remove(key);
                   
               }else{
                   hm.put(key,count);
               }
           }
       }return arr;
    }
}