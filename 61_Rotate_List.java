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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;

        if (head != null) {
            while (temp.next != null) {
                count++;
                temp = temp.next;
            }

            k = k % count;

            if (k > 0) {
                temp.next = head;
                temp = head;
                k = count - k;
                
                while (k > 1) {
                    temp = temp.next;
                    k--;
                }
                head = temp.next;
                temp.next = null;
            }
        }

        return head;
    }

}
