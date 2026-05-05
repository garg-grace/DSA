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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = getLengthOfLinkedList(head);
        if(k == len) return head;
        k = k%len;
        k=len-k;
        ListNode lastNode = head;
        ListNode kthNode = head;
        int cnt = 0;

        ListNode temp = head;
        while(temp != null) {
            cnt++;
            if(cnt == k) kthNode = temp;
            if(temp.next == null) lastNode = temp;

            temp = temp.next;
        }

        if(lastNode == kthNode) return head;

        ListNode head2 = kthNode.next;

        kthNode.next = null;
        lastNode.next = head;

        return head2;
    }

    private int getLengthOfLinkedList(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}