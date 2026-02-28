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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);

        head = sortList(head);
        mid = sortList(mid);

        return merge(head, mid);
    }

    public static ListNode getMid(ListNode temp) {
        ListNode mid, midPrev = null;

        while (temp != null && temp.next != null) {
            midPrev = (midPrev == null) ? temp : midPrev.next;
            temp = temp.next.next;
        }

        mid = midPrev.next;
        midPrev.next = null;

        return mid;
    }

    public static ListNode merge(ListNode head, ListNode mid) {
        if (head != null && mid != null) {
            if (head.val <= mid.val) {
                head.next = merge(head.next, mid);
                return head;
            }

            mid.next = merge(head, mid.next);
            return mid;
        }
        return head != null ? head : mid;
    }
}