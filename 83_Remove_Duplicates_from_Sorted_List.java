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

        if (head != null)
            head = sorted(head);

        return head;
    }

    public static ListNode sorted(ListNode temp) {
        if (temp.next == null)
            return temp;

        if (temp.next.val == temp.val)
            return sorted(temp.next);

        else {
            temp.next = sorted(temp.next);
            return temp;
        }
    }
}