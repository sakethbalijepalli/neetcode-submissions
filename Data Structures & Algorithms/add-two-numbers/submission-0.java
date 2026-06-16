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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //        l1 => 9 -> 9 -> 9 where 1 is one's place and 3 is in hundred's place,
        // l2 => 1 -> 1 -> 1 same as l1;
        ListNode sum = new ListNode(-1);
        int carry = 0;
        ListNode curr = sum;
        while (l1 != null || l2 != null){
            int l1Val = l1 != null ? l1.val : 0; // 9
            int l2Val = l2 != null ? l2.val : 0; // 1
            int sumOfDigits = l1Val + l2Val + carry; // we get 10
            carry = sumOfDigits / 10; // if the sum is 10, we get carry as 1
            int digit = sumOfDigits % 10; // digit will be 0
            curr.next = new ListNode(digit);

            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return sum.next;
    }
}
