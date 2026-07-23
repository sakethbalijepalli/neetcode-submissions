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
    public int pairSum(ListNode head) {
         ListNode fast = head;
        ListNode slow = head;
        ListNode rev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        while (slow != null){
            ListNode temp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = temp;
        }
        int max = Integer.MIN_VALUE;
        while (rev != null && head != null){
            int secondHalfVal = rev.val;
            int firstVal = head.val;
            max = Math.max(max,secondHalfVal + firstVal);
            rev = rev.next;
            head = head.next;
        }
        return max;
    }
}