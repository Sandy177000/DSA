public class palindrome_LL {
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
    public boolean isPalindrome(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode prev = slow;
        ListNode next;
        slow.next = null;

        while(curr!=null)
        {   
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode head2 = prev;
        ListNode head1 = head;

        while(head2!=null)
        {
            if(head1.val!=head2.val)
            {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}
}
