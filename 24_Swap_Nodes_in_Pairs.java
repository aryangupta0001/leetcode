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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode list = new ListNode(0, head);
        head = list;

        while (list != null) {
            list.next = swap(list.next);

            if (list.next == null)
                break;

            list = list.next.next;
        }

        return head.next;
    }

    public static ListNode swap(ListNode temp1) {
        if (temp1 != null && temp1.next != null) {
            ListNode temp2 = temp1.next;
            temp1.next = temp2.next;
            temp2.next = temp1;
            return temp2;
        }
        return temp1;
    }
}