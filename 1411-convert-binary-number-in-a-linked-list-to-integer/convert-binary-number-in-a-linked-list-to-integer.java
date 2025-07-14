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
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) {
        head = reverseList(head);
        int num=0;
        int temp=1;
        while(head!=null){
            num+=(temp*head.val);
            temp*=2;
            head=head.next;
        }
        return num;
    }
}