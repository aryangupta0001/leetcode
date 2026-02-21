class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merged(list1, list2);
    }
 
    public static ListNode merged(ListNode list1, ListNode list2) {
        if (list1 != null) {
            if (list2 != null) {
                if (list1.val < list2.val) {
                    list1.next = merged(list1.next, list2);
                    return list1;
                }

                else if (list1.val == list2.val) {
                    list1.next = merged(list1.next, list2);
                    return list1;
                }

                else {
                    list2.next = merged(list1, list2.next);
                    return list2;
                }
            }
            return list1;

        }
        return list2;
    }
}