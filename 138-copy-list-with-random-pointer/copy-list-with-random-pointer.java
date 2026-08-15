/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        Node curr = head;

        while(curr!= null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }


        curr = head;

        while(curr!= null){

            if(curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }


        Node copyhead = head.next;
        Node original = head;
        Node temp = copyhead;

        while(original != null){
            original.next = temp.next;
            original = original.next;
            
            if(original != null){
                temp.next = original.next;
            }
            
            temp = temp.next;
        }

        return copyhead;
    }
}