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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        return getNext(head, false);
    }

    public static ListNode getNext(ListNode temp, boolean prev) {
        boolean next;

        if (temp.next == null)
            return prev ? null : temp;

        if (prev)
            return getNext(temp.next, temp.val == temp.next.val);

        if (temp.val == temp.next.val)
            return getNext(temp.next, true);

        temp.next = getNext(temp.next, false);
        return temp;
    }
}