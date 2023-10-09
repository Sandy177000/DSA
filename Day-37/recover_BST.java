public class recover_BST {
    
	public static class Pair{
		int state;
		TreeNode node ;
		Pair(TreeNode node, int state){
			this.node = node;
			this.state = state;
		}
	}
	
	public static TreeNode getNextInorder(Stack<Pair> st)
	{
		// DFS iterative traversal
        while(!st.isEmpty())
        {
            Pair curr = st.peek();
            if(curr.state==1){
                curr.state++;
                if(curr.node.left!=null){
                    st.push(new Pair(curr.node.left,1));
                }
            }
            else if(curr.state==2)
            {
                curr.state++;
                if(curr.node.right!=null){
                    st.push(new Pair(curr.node.right,1));
                }
				// this will return inorder node and paused state of the stack 
				return curr.node;
            }
            else{
                st.pop();
            }

        }
		
			return null;
	}

    public static void recoverTree(TreeNode root) {

		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root,1));
		TreeNode curr = getNextInorder(st);
		TreeNode prev = curr;

		TreeNode a = null;
		TreeNode b = null;

		// to find out the swapped nodes the we check if the adjacent nodes 
		// in the inorder traversal should be sorted
		while(curr!=null){
			if(prev.val>curr.val){
			   if(a==null){
				    a = prev;
				    b = curr; 
			   }else{
				   b = curr;
			   }
			}
			prev = curr;
			curr = getNextInorder(st);
		}

		//Swapping the values of the pair
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
		 
    }

}
