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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int length =0;
        while(temp != null){
            length++;
            temp=temp.next;
        }

        int base = length / k;
        int extra = length % k;
        ListNode []  arr = new ListNode[k];
        ListNode curr = head;
        for(int i=0;i<k;i++){
            int part = base;

            if (extra > 0) {
                part++;
                extra--;
            }

            if (part == 0) {
                arr[i] = null;
                continue;
            }

            arr[i] = curr;

            for(int j=1;j<part;j++){
                curr = curr.next;
            }

            ListNode next = curr.next;
            curr.next = null;
            curr = next;

        }
        return arr;
    }
}