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
        ListNode temp1, temp2;

        temp1 = head;
        temp2 = head;

        int i = 1;

        while (temp1.next != null) {
            temp1 = temp1.next;

            if (++i > n+1)
                temp2 = temp2.next;
        }

        if(i == n)
            return head.next;

        temp2.next = temp2.next.next;

        return head;
    }
}