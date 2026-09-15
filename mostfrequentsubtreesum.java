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
    HashMap<Integer,Integer>map=new HashMap<>(); 
    int maxfreq=0;
    public int[] findFrequentTreeSum(TreeNode root) {
         dfs(root);
         ArrayList<Integer>ans=new ArrayList<>();
         for(Map.Entry<Integer,Integer>entry :map.entrySet()){
            if(entry.getValue()==maxfreq){
                ans.add(entry.getKey());
            }
         }int []result=new int[ans.size()];
         for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
         }return result;

    }public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftsum=dfs(root.left);
        int rightsum=dfs(root.right);
         int sum=leftsum+rightsum+root.val;
         map.put(sum,map.getOrDefault(sum,0)+1);
          maxfreq=Math.max(maxfreq,map.get(sum));
          return sum;
    }
}
