public class flatten_single_LL_in_sorted_order {
  
	static Node flatten(Node root) 
  {
	return recur(root, root.right);
  }

  static Node recur(Node curr, Node next)
  {   
	  // base case
	  if(next==null)
	  {
		  return curr;
	  }
	  // merge lists and return node of merged list
	  Node mergedHead = merge(curr,next);

	 return recur(mergedHead,next.right); // recursively call for merged list and next node in the right
	  
  }

  // basic merge function of two lists using 2 Nodes
  static Node merge(Node X, Node Y)
  {
		Node ans = new Node(-1);
	    Node anshead = ans;
	 
	    while(X!=null && Y!=null)
		{
			if(X.data>Y.data){
				ans.down = Y;
				ans = ans.down;
				Y = Y.down;
			}
			else{
				ans.down = X;
				ans = ans.down;
				X = X.down;
			}
		}

	    while(X!=null)
		{	
			ans.down = X;
			ans = ans.down;
			X = X.down;
		}
	 
	    while(Y!=null)
		{
			ans.down = Y;
			ans = ans.down;
			Y = Y.down;
		}
	    anshead = anshead.down;
	    return anshead; 
    }

}
