class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0 || lists == null)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode(0), temp = head;

        int i = 0;

        while(i<lists.length)
            if(lists[i++] != null)
                pq.offer(lists[i-1]);

        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;

            if(temp.next != null)
                pq.offer(temp.next);
        }

        return head.next;
    }
}
