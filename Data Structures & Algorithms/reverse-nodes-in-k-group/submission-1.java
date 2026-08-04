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
        if(head == null || k == 0 || k == 1){
            return head;
        }
        ListNode kth = head;
        int localK = k;
        while (localK > 1 && kth != null){
            kth = kth.next;
            localK--;
        }
        if(kth == null){
            return head;
        }
        ListNode nextGroup = kth.next;
        kth.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(nextGroup,k);
        return newHead;
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode localTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = localTemp;
        }
        return prev;
    }
}
