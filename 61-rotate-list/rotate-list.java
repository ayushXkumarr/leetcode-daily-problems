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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode temp = head;

        int count =0;
        ListNode tail =null;
        while(temp!= null){
            count++;
            if(temp.next == null){
                tail = temp;
            }
            temp = temp.next;

        }

        k = k % count;
        if (k == 0) {
            return head;
        }

        int idx = count -k;
        ListNode curr = head;
        
        for(int i=1 ;i<idx;i++){
            curr = curr.next;
        }
        ListNode newhead = curr.next;
        tail.next = head;
        curr.next = null;

        return newhead;

    }
}