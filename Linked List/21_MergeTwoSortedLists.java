/***********************************************
Time Complexity : O(n + m)
Space Complexity : O(1)
https://leetcode.com/problems/merge-two-sorted-lists/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;
        
        while(l1 !=null && l2 !=null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 =l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return prev.next;
    }
}