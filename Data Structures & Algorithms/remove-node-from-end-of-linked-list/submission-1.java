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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode firstPointer = head;
        ListNode curr = new ListNode(-1);
        curr.next = head;
        for(int i = 0;i < n;i++){
            firstPointer = firstPointer.next;
        }
        ListNode prev = curr;
        while (firstPointer != null){
            firstPointer = firstPointer.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return curr.next;
    }
}
