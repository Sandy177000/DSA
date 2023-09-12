public class insert_node_BST {
    
class Solution{
    public Node insertNode(Node root, int val)
	{
        // create a new Node to be inserted
        
		if(root==null) return new Node(val);
		
		if(root.val>val){
			// calling function for left subtree which returns the node
			// at which we want to insert
			Node newLeft =  insertNode(root.left,val);
			root.left = newLeft; // link the new child leaf Node created to the parent root
		}
		else{
			Node newRight = insertNode(root.right,val);
			root.right = newRight;
		}

		return root;
    }
}
    
}
