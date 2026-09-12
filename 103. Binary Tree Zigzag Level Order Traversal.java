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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        List<List<Integer>>ans= new ArrayList<>();
        if(root==null) return ans;
        q.offer(root);
        int k=0;
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer>lst=new ArrayList<>();
            for(int i=0;i<s;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }lst.add(q.poll().val);
            }if(k%2==1){
                Collections.reverse(lst);
                ans.add(lst);
            }else{
            ans.add(lst);
            }
            k++;
        }return ans;
    }
}
