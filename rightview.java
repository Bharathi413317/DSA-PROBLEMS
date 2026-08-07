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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer>lst=new ArrayList<>();
            int k=q.size();
            for(int i=0;i<k;i++){
            if(q.peek().left!=null) q.offer(q.peek().left);
            if(q.peek().right!=null) q.offer(q.peek().right);
            lst.add(q.poll().val);
            }ans.add(lst);


        }ArrayList<Integer>arr=new ArrayList<>();
        for(List<Integer>a: ans){
            arr.add(a.get(a.size()-1));
        }return arr;
    }
}
