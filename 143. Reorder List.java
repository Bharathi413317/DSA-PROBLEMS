class Solution {
    public void reorderList(ListNode head) {
      if(head==null || head.next==null) return;
      ListNode curr=head;
      while(curr!=null || curr.next!=null){
        ListNode prev=null;
        ListNode last=curr;
        while(last.next!=null){
            prev=last;
            last=last.next;
        }if(last==curr || last==curr.next){
            break;
        }prev.next=null;
         last.next=curr.next;
         curr.next=last;

         curr=last.next;
      }
        
    }

}
