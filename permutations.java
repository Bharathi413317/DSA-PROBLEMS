class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>>ans=new ArrayList<>();
      helper(nums,0,ans);
      return ans;
    }public void helper(int[] nums,int index,List<List<Integer>>ans){
        List<Integer>temp=new ArrayList<>();
        if(index==nums.length){
            for(int num:nums){
                temp.add(num);
            }ans.add(temp);
            return;
        }for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            helper(nums,index+1,ans);
            swap(nums,index,i);
        }
    }public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
