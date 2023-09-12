public class binary_tree_coloring {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    
    public TreeNode find(TreeNode root, int x){

            if(root==null || root.val==x) return root;

            TreeNode left = find(root.left,x);

            if(left!=null)  return left;

            return find(root.right,x);
    }
    
    // count the number of nodes in the left and right subtree of the node
    public int count(TreeNode redNode)
    {
        if(redNode==null) return 0;
        return 1 + count(redNode.left) + count(redNode.right);
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) 
    {
        TreeNode redNode = find(root,x);
        int leftCount = count(redNode.left);
        int rightCount = count(redNode.right);

        if((leftCount+rightCount<n/2)|| leftCount>n/2 || rightCount>n/2){
            return true;
        }

        return false;
    }
}

















}
