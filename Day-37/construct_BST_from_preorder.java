public class construct_BST_from_preorder {
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	public static int idx;

	public static TreeNode construct(int[] pre, int lower, int upper){

		if(idx== pre.length) return null;
		if(pre[idx] <lower || pre[idx] >upper) return null;

		// make a new node at index idx
		TreeNode root =  new TreeNode(pre[idx]);
		idx++;

		root.left = construct(pre,lower,root.val-1);
		root.right = construct(pre,root.val+1, upper);

		return root;
	}
}
