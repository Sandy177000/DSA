public class binary_linked_list_to_decimal {
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
    public int getDecimalValue(ListNode head) {
        
        ListNode temp = head;
        int num=0;
        int size=0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        temp = head;

        while(temp!=null)
        {
            num += temp.val*(int)Math.pow(2,size-1);
            size--;
            temp = temp.next;
        }
        return num;
    }
}
}
