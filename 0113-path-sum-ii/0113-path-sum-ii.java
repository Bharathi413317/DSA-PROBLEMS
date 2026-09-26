
class Solution {
    public void dfs(TreeNode root,int ts,List<List<Integer>>lst,List<Integer>l){
           if(root==null){
            return;
           }
           l.add(root.val);
         
           if(root.left==null && root.right==null && ts==root.val){
            lst.add(new ArrayList(l));
           }
            dfs(root.left,ts-root.val,lst,l);
            dfs(root.right,ts-root.val,lst,l);
            l.remove(l.size()-1);
           }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lst=new ArrayList<>();
        List<Integer>l=new ArrayList<>();
        dfs(root,targetSum,lst,l);
        return lst;
        
        
    }
}