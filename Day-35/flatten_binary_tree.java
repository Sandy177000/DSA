public class flatten_binary_tree {
    
class Solution
{
    public static void flatten(Node root){
        //Write code here
		if(root==null) return ;

		flatten(root.left);
		flatten(root.right);

		if(root.left!=null)
		{
			
			Node temp = root.right;
			// link right node to left node
			root.right = root.left;

			Node curr = root.left;

			// move to right most end 
			while(curr.right!=null){
				curr = curr.right;
			}

			// link the rightmost end to previous right
			curr.right = temp;
			// make the left node null
			root.left=null;	
		}
		
    }
}
}
