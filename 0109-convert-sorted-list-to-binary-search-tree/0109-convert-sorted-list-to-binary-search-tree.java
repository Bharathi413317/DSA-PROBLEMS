class Solution {
    public TreeNode ConstructBst(List<Integer>lst,int start,int end){
        if(start>end){
            return null;
           }
               int mid=(start+end)/2;
           TreeNode root=new TreeNode(lst.get(mid));
         
        root.left=ConstructBst(lst,start,mid-1);
        root.right=ConstructBst(lst,mid+1,end);
       
        
        return root;

    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer>lst=new ArrayList<>();
        if(head==null){
            return null;
        }
        ListNode temp=head;
        while(temp!=null){
            lst.add(temp.val);
            temp=temp.next;
        }
        
        TreeNode root=ConstructBst(lst,0,lst.size()-1);
        return root;

        
    }
}