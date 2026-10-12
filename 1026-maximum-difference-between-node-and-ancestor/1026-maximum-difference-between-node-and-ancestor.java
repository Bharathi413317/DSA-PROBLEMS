class Solution {
    public int maxAncestorDiff(TreeNode root) {
       return findabs(root,root.val,root.val);
    }public int findabs(TreeNode root,int max,int min){
        if(root==null){
            return max-min;
        }
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);
        int leftdiff=findabs(root.left,max,min);
        int rightdiff=findabs(root.right,max,min);
        return Math.max(leftdiff,rightdiff);
    }
}