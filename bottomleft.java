/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        ArrayList<List<Integer>>ans=new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int k=q.size();
            ArrayList<Integer>arr=new ArrayList<>();
            for(int i=0;i<k;i++){
                  if(q.peek().left !=null){
                       q.add(q.peek().left);
                  }if(q.peek().right !=null){
                      q.add(q.peek().right);
                  }arr.add(q.poll().val);
            }ans.add(arr);
        }
           List<Integer> lastList = ans.get(ans.size() - 1);

        return lastList.get(0);
    }
}
