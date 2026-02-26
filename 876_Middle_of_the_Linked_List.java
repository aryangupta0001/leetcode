class Solution {
    public ListNode middleNode(ListNode head) {
        return move(head, head);
    }

    public static ListNode move(ListNode temp1, ListNode temp2){
        if(temp2.next != null)
            temp2 = temp2.next;
        else
            return temp1;
        
        temp2 = temp2.next == null ? temp2 : temp2.next;
        temp1 = temp1.next;

        return move(temp1, temp2);
    }
}