public class convert_BST_to_greater_tree {
    class Solution {
        public TreeNode convertBST(TreeNode root) {

            // inorder traversal
            if(root==null) return null;

            convertBST(root.left);
            root.val = solve(root.right); // store sum of the right part of the node
            convertBST(root.right);
    
            return root;
            
        }
    
        // function to return sum of the tree
        public int solve(TreeNode node)
        {
            if(node==null) return 0;
            return node.val + solve(node.left) + solve(node.right);	
        }
    }
}
