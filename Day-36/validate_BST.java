public class validate_BST {
    
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
