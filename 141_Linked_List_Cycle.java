/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp1 = head, temp2 = head;

        while(temp1 != null && temp2 != null){
            temp2 = temp2.next;
            
            if(temp1.next != null)
                temp1 = temp1.next.next;
            else
                return false;

            if(temp1 == temp2)
                return true;
        }

        return false;
    }
}