class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstfrominorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }public TreeNode bstfrominorder(int []preorder,int bound,int []i){
        if(i[0]==preorder.length || preorder[i[0]]>bound) return null;
        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=bstfrominorder(preorder,root.val,i);
        root.right=bstfrominorder(preorder,bound,i);
        return root;
    }
}