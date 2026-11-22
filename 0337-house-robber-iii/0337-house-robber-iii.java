
 class Solution {

    public int rec(TreeNode root,HashMap<TreeNode,Integer>dp) {

        if(root == null) return 0;

        
      if(dp.containsKey(root)){
        return dp.get(root);
      }

        int inc = root.val;

        if(root.left != null && root.left.left!=null) {
            inc += rec(root.left.left,dp);
        }if(root.left!=null && root.left.right!=null){
            inc += rec(root.left.right,dp);
        }

        if(root.right != null && root.right.left!=null) {
            inc += rec(root.right.left,dp);
        }if(root.right!=null && root.right.right!=null){
            inc += rec(root.right.right,dp);
        }

        int exc = rec(root.left,dp) + rec(root.right,dp);
         int ans=Math.max(inc, exc);
         dp.put(root,ans);
        return ans;

    }

    public int rob(TreeNode root) {
        if(root==null) return 0;
        HashMap<TreeNode,Integer>dp=new HashMap<>();
        return rec(root,dp);
    }
 }
    // int robbed(TreeNode root,HashMap<TreeNode,Integer>dp){
    //     if(root==null) return 0;
    //     if(dp.containsKey(root)){
    //         return dp.get(root);
    //     }
    //   int ans=  root.val+missed(root.left,dp)+missed(root.right,dp);
    //   dp.put(root, ans);
    //     return ans;
    // }
    // int missed(TreeNode root,HashMap<TreeNode,Integer>dp){
    //     if(root==null) return 0;
    //      if(dp.containsKey(root)){
    //         return dp.get(root);
    //     }
    //   int ans=  Math.max(robbed(root.left,dp),missed(root.left,dp))+Math.max(robbed(root.right,dp),missed(root.right,dp));
    //   dp.put(root, ans);
    //     return ans;
    


