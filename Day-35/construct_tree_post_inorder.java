public class construct_tree_post_inorder {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return solve(inorder,0,inorder.length-1, postorder,0, postorder.length-1,map);
    }

    public TreeNode solve(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,HashMap<Integer, Integer> map )
    {
        if(ps>pe|| is>ie) return null;
        
        TreeNode root = new TreeNode(postorder[pe]);

        // get the index from the map
        int inroot = map.get(root.val);

        // find the number of elements
        int num = inroot - is;

        // check in the left part of the inorder and postorder
        root.left = solve(inorder,is,inroot-1,postorder,ps,ps+num-1,map);

        root.right = solve(inorder,inroot+1,ie,postorder,ps+num,pe-1,map);

        return root;

    }

}














}
