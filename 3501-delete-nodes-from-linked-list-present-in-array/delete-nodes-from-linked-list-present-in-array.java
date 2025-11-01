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
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }

        ListNode newHead = new ListNode(0,null);
        ListNode temp = newHead;

        while(head!=null){
            if(!st.contains(head.val)){
                temp.next=head;
                temp=temp.next;
            }
            head=head.next;
        }
        temp.next=null;
        return newHead.next;
    }
}