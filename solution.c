/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *Sum, *New, *temp;
    int carry = 0, sum;

    Sum = (struct ListNode *) malloc(sizeof(struct ListNode));

    sum = l1 -> val + l2 -> val + carry;
    carry = sum/10;

    Sum -> val = sum%10;
    Sum -> next = NULL;
    temp = Sum;

    l1 = l1 -> next;
    l2 = l2 -> next;


    while(l1 != NULL || l2 != NULL || carry)
    {   New = (struct ListNode *) malloc(sizeof(struct ListNode));
        
        sum = carry;

        if(l1 != NULL)
        {
            sum += l1 -> val;
            l1 = l1 -> next;
        }   
        
        if(l2 != NULL)
        {
            sum += l2 -> val;
            l2 = l2 -> next;
        }
        
        carry = sum/10;
        
        New -> val = sum%10;
        New -> next = NULL;
        
        temp -> next = New;
        temp = New;
    }


    return Sum;

}
