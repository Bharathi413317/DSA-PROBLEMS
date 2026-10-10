
class Solution {
    public TreeNode Construct(int[] nums,int start,int end){
        if(start>end){
            return null;
        }int max=Integer.MIN_VALUE;
        int maxindx=-1;
        for(int i=start;i<=end;i++){
                if(nums[i]>max){
                    max=nums[i];
                    maxindx=i;
                }
        }
        TreeNode root=new TreeNode(max);
        root.left=Construct(nums,start,maxindx-1);
        root.right=Construct(nums,maxindx+1,end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        TreeNode root=Construct(nums,0,nums.length-1);
        return root;
        
    }
}