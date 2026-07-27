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
    public ListNode partition(ListNode head, int x) {


        if (head == null) return null;
        ListNode smallVal = new ListNode(-1);
        ListNode smallpoint = smallVal;

        ListNode LargeVal = new ListNode(-1);
        ListNode largepoint = LargeVal;

        ListNode curr = head;

        while(curr != null){
            if(curr.val < x){
                smallpoint.next = curr;
                smallpoint = curr;
                curr = curr.next;
            }else{
                largepoint.next = curr;
                largepoint = largepoint.next;
                curr = curr.next;
            }
        }

        smallpoint.next = LargeVal.next;
        largepoint.next = null;

        return smallVal.next;
    }
}