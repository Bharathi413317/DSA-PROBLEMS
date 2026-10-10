public class BstIterator{
    Stack<TreeNode>st=new Stack<TreeNode>();
    boolean reverse=true;
    public BstIterator(TreeNode root,Boolean isreverse){
   
             reverse=isreverse;
             pushall(root);
    }
    public boolean hasnext(){
              return !st.isEmpty();
    }public int next(){
          TreeNode temp=st.pop();
          if(reverse==false){
            pushall(temp.right);
          }else{
            pushall(temp.left);
          }return temp.val;
    }private void pushall(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse==true){
                root=root.right;
            }else{
                root=root.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BstIterator l=new BstIterator(root,false);
        BstIterator r=new BstIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k){
                i=l.next();
            }else{
            j=r.next();
            }
        }return false;

    }
}
