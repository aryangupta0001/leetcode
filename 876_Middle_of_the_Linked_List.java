class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp1 = head, temp2 = head;
        
        while (temp2.next != null) {
            temp2 = temp2.next;
            temp2 = temp2.next == null ? temp2 : temp2.next;
            temp1 = temp1.next;
        }
        return temp1;
    }
}