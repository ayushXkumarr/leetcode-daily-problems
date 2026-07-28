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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int groups = length / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (groups-- > 0) {

            ListNode beforeReverse = groupPrev;
            ListNode afterReverse = groupPrev.next;

            ListNode prev = beforeReverse;
            ListNode curr = afterReverse;
            ListNode next = null;

            for (int i = 1; i <= k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            beforeReverse.next = prev;
            afterReverse.next = curr;

            // Move to next group
            groupPrev = afterReverse;
        }

        return dummy.next;
    }
}