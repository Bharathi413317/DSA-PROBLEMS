class Solution {
    public int maxPathSum(TreeNode root) {
        int []max_value=new int[1];
        max_value[0]=Integer.MIN_VALUE;
        maxpathdown(root,max_value);
        return max_value[0];
    }private int maxpathdown(TreeNode node,int []max_value){



        if(node==null) return 0;
        int left=Math.max(0,maxpathdown(node.left,max_value));
        int right=Math.max(0,maxpathdown(node.right,max_value));
        max_value[0]=Math.max(max_value[0],left+right+node.val);
        return Math.max(left,right)+node.val;


    }
 }
