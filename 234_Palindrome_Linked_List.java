class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        return findMid(head);
    }

    public static boolean findMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null, temp = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        if (fast != null)
            slow = slow.next;

        while (prev != null)
            if (prev.val == slow.val) {
                prev = prev.next;
                slow = slow.next;
            }

            else
                return false;

        return true;
    }
}