/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null && left == right){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        for(int i=1;i<left;i++){
            prev = curr;
            curr = curr.next;

        }

        ListNode lastend = prev;
        ListNode newend = curr;

        ListNode next = null;

        for(int i=1; curr!= null && i<=right - left +1;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }

        if(lastend != null){
            lastend.next = prev;
        }else{
            head = prev;
        }

        newend.next = curr;

        return head;
    }
}