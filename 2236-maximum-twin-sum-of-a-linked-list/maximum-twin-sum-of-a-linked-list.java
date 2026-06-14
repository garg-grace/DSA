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
        ListNode reverse = constructReverseLL(head);
        int maxSum = 0;

        while(null != head) {
            maxSum = Math.max(maxSum, head.val+reverse.val);
            head = head.next;
            reverse = reverse.next;
        }
        return maxSum;
    }

    private ListNode constructReverseLL(ListNode head) {
        ListNode reverseHead = null;
        while(null != head) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = reverseHead;
            reverseHead = newNode;
            head = head.next;
        }
        return reverseHead;
    }
}