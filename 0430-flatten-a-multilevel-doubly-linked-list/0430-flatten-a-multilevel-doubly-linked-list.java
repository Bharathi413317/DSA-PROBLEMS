class Solution {
    public Node flatten(Node head) {

        if (head == null)
            return null;

        Node curr = head;

        while (curr != null) {

            if (curr.child != null) {

                Node child = curr.child;
                Node next = curr.next;

                curr.next = child;
                child.prev = curr;
             
              flatten(child);

Node tail = child;

while (tail.next != null) {
    tail = tail.next;
}

                curr.child = null;

                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }       if (curr.next == null)
                break;

            curr = curr.next;
        }

        return head;
    }
}