public class diameter_of_tree {
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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        int left_height = height(root.left);
        int right_height = height(root.right);

        int maxPath = left_height+right_height; // total dist from extreme node at left to right of tree

        return Math.max(maxPath,Math.max(left,right));

    }

    public int height(TreeNode node){
        if(node==null) return 0;

        int left = 1+height(node.left);
        int right = 1+height(node.right);

        return Math.max(left,right);

    }




}




}
