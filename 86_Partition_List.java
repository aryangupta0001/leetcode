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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode smallFirst = null, smallLast = null, greaterFirst = null, greaterLast = null;

        ListNode cur = head, prev = head;

        while (cur != null) {
            if (cur.val < x) {
                if (smallFirst == null)
                    smallFirst = cur;

                else if (prev.val >= x) {
                    smallLast.next = cur;
                    prev.next = cur.next;
                }
                smallLast = cur;
            }

            else {
                if (greaterFirst == null)
                    greaterFirst = cur;

                else
                    greaterLast.next = cur;
                greaterLast = cur;
            }
            prev = cur;
            cur = cur.next;
        }

        if (smallFirst != null) {
            head = smallFirst;
            smallLast.next = greaterFirst;
        }

        else
            head = greaterFirst;

        if (greaterLast != null)
            greaterLast.next = null;

        return head;
    }
}