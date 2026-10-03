

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>lst=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                lst.add(curr.val);
                for(Node child:curr.children){
                    q.add(child);
                }

            }ans.add(lst);
           

            }
        return ans;
        
    }
}