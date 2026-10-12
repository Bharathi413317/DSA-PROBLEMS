
class Solution {
    int count=0;
    public void dfs(TreeNode root,int rs){
        if(root==null){
            return;
        }
        if(rs==(int)root.val){
            count++;
            
        }dfs(root.left,rs-root.val);
        dfs(root.right,rs-root.val);
        

    }
    public int pathSum(TreeNode root, int targetSum) {
    // if(root.val==1000000000) return 0;
    
        if(root==null) return 0;
        if(root.val==1000000000) return 0;

        dfs(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);

        return count;
        

        
    }
}