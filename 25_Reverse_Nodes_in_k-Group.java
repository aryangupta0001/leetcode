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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1)
            return head;

        ListNode newHead = new ListNode(0), next = head;

        ListNode last = newHead;

        while (next != null) {
            int i = 0;

            ListNode curr = next, temp = next;

            while (i++ < k - 1) {
                if (temp.next == null) {
                    last.next = curr;
                    return newHead.next;
                }
                temp = temp.next;
            }

            next = temp.next;
            temp.next = null;

            last = reverse(last, curr);
        }

        return newHead.next;
    }

    public static ListNode reverse(ListNode last, ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;

            if (next != null)
                next = next.next;
        }

        last.next = prev;
        head.next = null;

        return head;
    }
}