public class reverse_LL_in_between {
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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {    
        ListNode prevLeft = null;
        ListNode currLeft = head;//1
        
        for(int i=1;i<=left-1;i++){
            prevLeft = currLeft;
            currLeft = currLeft.next;
        }

        // reversing (right-left+1) times
        ListNode prev = prevLeft; // 1
        ListNode curr = currLeft; // 2
        ListNode next;
        for(int i=1;i<=right-left+1;i++)
        {  
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        currLeft.next = curr; // 2->5

        if(prevLeft==null){
            head = prev;
        }
        else{
            prevLeft.next = prev; // 1->4
        }

        return head;
    }
}
}
