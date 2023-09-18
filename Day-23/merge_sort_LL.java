public class merge_sort_LL {
 

    class Solution {
        public static Node mergesort(Node head)
        {
            if(head.next==null || head==null)
            {
                  return head;
            }
    
            //find mid
            Node mid = getMid(head);

            //divide 
            Node righthead = mid.next;
            mid.next = null;

            Node left = mergesort(head); // head->---- ->mid->null
            Node right = mergesort(righthead);  // mid.next->---- ->null
            
            //merge
            return merge(left, right); // sort and merge LL 
            
            
        }
    
        public static Node getMid(Node x)
        {
        
            Node slow = x;
            Node fast = x.next;
    
            while(fast!=null && fast.next!=null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }		
    
            return slow;
        }
    
        
    
        public static Node merge(Node X, Node Y)
        {
            Node anshead = new Node(-1);
            Node ans = anshead;
         
            while(X!=null && Y!=null)
            {
                if(X.data>Y.data){
                    ans.next = Y;
                    ans = ans.next;
                    Y = Y.next;
                }
                else{
                    ans.next = X;
                    ans = ans.next;
                    X = X.next;
                }
            }
    
            while(X!=null)
            {	
                ans.next = X;
                ans = ans.next;
                X = X.next;
            }
         
            while(Y!=null)
            {
                ans.next = Y;
                ans = ans.next;
                Y = Y.next;
            }
    
            return anshead.next;
            
        }
    }
    
    
    class Node{
        int data;
        Node next = null;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    class LinkedList{
        Node head;
        void add(int data){
            Node new_node = new Node(data);
            if(head == null){
                head = new_node;
                return;
            }
            Node curr = head;
            while(curr.next != null)
                curr = curr.next;
            curr.next = new_node;
        }
    }
        
}
