public class delete_node_BST {
    
class Solution{

	public Node findMin(Node root){
		if(root.left==null) return root;
		
		return findMin(root.left);
	}
    public Node deleteNode(Node root, int val){

		if(root==null) return null;

		// root to be deleted
		if(root.val==val){
			// Case 1: check if root is leaf
			if(root.left==null &&  root.right==null){
				return null; // this means the leaf node is deleted
			}
			// Case 2: check if root to be deleted has single child nodes
			else if(root.left!=null && root.right==null){
				return root.left;
			}
			else if(root.right!=null && root.left == null){
				return root.right;
			}

			//Case 3: check if root to be deleted has both the  child nodes
			           // find the minimum Node in the right
			           // replace the value of node to be deleted with the minimum value found
			           // delete the original node which was found
			
			Node minRight = findMin(root.right);
			root.val = minRight.val;
			deleteNode(root.right, minRight.val);
			
		}

		if(root.val>val)
		{
			//find in left subtree
			Node nodeLeft = deleteNode(root.left,val);
			root.left = nodeLeft;
		}
		else{
			Node nodeRight = deleteNode(root.right,val);
			root.right = nodeRight;
		}

		return root;
		
    }
}
}
