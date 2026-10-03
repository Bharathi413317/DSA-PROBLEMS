class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        int expected=1;
        root.val=1;    
        q.add(root);
        while(!q.isEmpty()){
            TreeNode a=q.remove();
            if(a.val!=expected){
                return false;
            }expected++;
            if(a.left!=null){
                a.left.val=2*a.val;
                q.add(a.left);
            }if(a.right!=null){
                a.right.val=2*a.val+1;
                q.add(a.right);
            }
        }return true;
    }
}