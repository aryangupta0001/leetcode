class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;
    
        ListNode head, temp;

        int i = 0, j = -1, min = Integer.MAX_VALUE;

        while(i<lists.length){
            if(lists[i] != null)
                if(min > lists[i].val){
                    min = lists[i].val;
                    j = i;  
                }

            i++;
        }

        if(j==-1)
            return null;
        
        head = lists[j];
        temp = head;

        lists[j] = lists[j].next;

        j = -1;

        while(true){
            i = 0;
            min = Integer.MAX_VALUE;
            j = -1;

            while(i<lists.length){
                if(lists[i] != null){
                    if(min > lists[i].val){
                        min = lists[i].val;
                        j = i;
                    }
                }
                i++;
            }

            if(j == -1)
                break;

            temp.next = lists[j];
            temp = temp.next;
            lists[j] = lists[j].next;

        }

        return head;
    }
}