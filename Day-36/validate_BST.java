public class validate_BST {
    

	class Solution {
		public boolean isValidBST(TreeNode root) {
			
		   return solve(root,Long.MIN_VALUE,Long.MAX_VALUE);
	
		}
	
		public boolean solve(TreeNode root, long lower, long higher){
			if(root==null) return true;
	
			if(root.val<=lower || root.val>=higher) return false;
	
			return solve(root.right,root.val,higher) && solve(root.left,lower,root.val); 
	
		}
	}
	
class Solution{
    boolean isBST(Node root)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		solve(root,ans);
		// if the inorder of the tree is sorted then the tree is a valid bst
		for(int i=1;i<ans.size();i++){
			if(ans.get(i)<ans.get(i-1)){
				return false;
			}
		}

		return true;
    }

	void solve(Node root, ArrayList<Integer> ans){

		if(root==null) return ;

		solve(root.left,ans);
		ans.add(root.data);
		solve(root.right, ans);
	}
}
}
