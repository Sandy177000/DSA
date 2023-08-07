public class remove_duplicates_in_LL {
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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode h = head;
        while(h!=null)
        {
            while(h.next!=null && h.val==h.next.val)
            {   
                h.next = h.next.next;
            }
            h = h.next;
        }

        return head;
    }
}
}
