class Solution {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        TreeNode t=inorder(root,k);
        return t.val;
    }public TreeNode inorder(TreeNode root, int k){
        if(root==null) return null;
       TreeNode left= inorder(root.left,k);
       if(left!=null){
        return left;
       }
    
        count++;
        if(count==k) return root;
        TreeNode right=inorder(root.right,k);
        if(right!=null){
            return right;
        }
    return null;
        
    }
}