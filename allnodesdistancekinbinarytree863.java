/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root,Map<TreeNode,TreeNode>parentmap){
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                parentmap.put(curr.left,curr);
                q.offer(curr.left);

            }if(curr.right!=null){
                parentmap.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parentmap=new HashMap<>();
        markParents(root,parentmap);
        Queue<TreeNode>Q=new LinkedList<>();
        Map<TreeNode,Boolean>visited=new HashMap<>();
        Q.offer(target);
        visited.put(target,true);
        int currdist=0;
        while(!Q.isEmpty()){
              if(currdist==k) break;
              int siz=Q.size();
              for(int i=0;i<siz;i++){
                TreeNode curr=Q.poll();
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    Q.offer(curr.left);
                    visited.put(curr.left,true);
                }if(curr.right!=null && !visited.containsKey(curr.right)){
                    Q.offer(curr.right);
                    visited.put(curr.right,true);
                } if (parentmap.containsKey(curr) &&
                    !visited.containsKey(parentmap.get(curr))) {

                    TreeNode parent = parentmap.get(curr);

                    Q.offer(parent);
                    visited.put(parent, true);
                }
              }currdist++;

        }List<Integer>result=new ArrayList<>();
        while(!Q.isEmpty()){
            result.add(Q.poll().val);
        }return result;
    }
}
