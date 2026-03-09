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
    public void reorderList(ListNode head) {
        if(head.next == null)
            return;

        ListNode head1 = head;

        ListNode mid = getMid(head1);

        ListNode head2 = getReverse(mid.next);
        
        mid.next = null;

        while(head2 != null){
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            
            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }

    public static ListNode getMid(ListNode head){
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode getReverse(ListNode head){
        ListNode prev= null;
        ListNode temp = head;

        while(head != null){
            temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }

        return temp;
    }
}