/***********************************************
Time Complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 respectively, the algorithm above iterates at most max(m, n) times.
Space Complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
https://leetcode.com/problems/add-two-numbers/
***********************************************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            int sum = carry;
            
            if(l1 !=null ) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 !=null ) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
        
            ListNode nextDigit = new ListNode(sum);
            head.next = nextDigit;
            head = head.next;
        }
        if(carry > 0) {
            ListNode nextDigit = new ListNode(carry);
            head.next = nextDigit;
        }
        return dummy.next;
    }
}