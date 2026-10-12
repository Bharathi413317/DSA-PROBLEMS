

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isvalid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }public boolean isvalid(TreeNode root,long minval,long maxval){
        if(root==null) return true;
        if(root.val>=maxval || root.val<=minval) return false;
        return isvalid(root.left,minval,root.val) && isvalid(root.right,root.val,maxval);
    }
}