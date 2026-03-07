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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;

        ListNode newHead = new ListNode(0, head);
        ListNode prev = newHead, temp = head;

        int i = 1;

        while (i++ < left) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = reverse(temp, right - left);

        return newHead.next;
    }

    public static ListNode reverse(ListNode head, int steps) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        while (steps-- > 0) {
            cur.next = prev;
            prev = cur;
            cur = next;

            if (next != null)
                next = next.next;
        }

        head.next = cur;
        return prev;
    }
}