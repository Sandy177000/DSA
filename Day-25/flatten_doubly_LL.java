public class flatten_doubly_LL {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution 
{
    public Node flatten(Node head) 
    {
        // store current head
        Node curr = head;
        // traverse through Linked List
        while(curr!=null)
        {   // check if the child is present
            if(curr.child!=null)
            {   
                // find the tail of the child
                Node tail = findTail(curr.child);

                // join tail with next of curr node
                if(curr.next!=null){
                    curr.next.prev = tail;
                }
                tail.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                // make child null
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    Node findTail(Node node)
    {
        while(node.next!=null)
        {
            node = node.next;    
        }
        // return tail of the child list
        return node;
    }
}
}
