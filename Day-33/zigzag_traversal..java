public class zigzag_traversal{
    

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public static void binaryTreeZigZagTraversal(Node root) 
	{

        // level-order traversal in the tree
		Queue<Node> q = new LinkedList<>();

		Stack<Integer> stack = new Stack<>();
		
		q.add(root);
		int level  = 0;
		while(q.size()>0){

			int n  = q.size();
			for(int i=0;i<n;i++)
			{ 
				    // pick the first pushed item from queue
				
					Node node  = q.remove();

				// print left node if not null
					if(node.left!=null){
						q.add(node.left);
					}
				// print right node if not null
					if(node.right!=null){
						q.add(node.right);
					}

				if(level%2==0)
					System.out.print(node.data+" ");

				// add in stack to print in reverse direction
				else
					stack.add(node.data);
			}

			level++;
			while(!stack.isEmpty()){
				System.out.print(stack.pop()+" ");
			}
		}
    }
}
}
