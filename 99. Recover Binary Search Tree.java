class Solution {
    private TreeNode first;
    private TreeNode last;
    private TreeNode middile;
    private TreeNode prev;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){
                first=prev;
                middile=root;
            }else{
                last=root;
            }
        }prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=null;
        last=null;
        middile=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last != null){
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }else if(first!=null && middile!=null){
               int temp=first.val;
               first.val=middile.val;
               middile.val=temp;
        }
    }
}
