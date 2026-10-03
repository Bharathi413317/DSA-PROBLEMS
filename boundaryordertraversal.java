/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        
         ArrayList<Integer>ans=new ArrayList<>();
         if(root==null) return ans;
         if(!isLeaf(root)) ans.add(root.data);
         
         addLeftBoundary(root,ans);
         addleaves(root,ans);
         addrightboundary(root,ans);
         return ans;
    }public boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }public void addLeftBoundary(Node root,ArrayList<Integer>ans){
        Node curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                ans.add(curr.data);
            }if(curr.left!=null){
                curr=curr.left;
                }else{
                    curr=curr.right;
                }
        }
    }public void addleaves(Node root,ArrayList<Integer>ans){
        if(root==null){
            return;
        }if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        addleaves(root.left,ans);
        addleaves(root.right,ans);
    }public void addrightboundary(Node root,ArrayList<Integer>ans){
        Node curr=root.right;
        Stack<Integer>st=new Stack<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                st.push(curr.data);
            }if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }
}
