public class trim_tree {
    
class Solution{

	public static Node trimTree(Node root, int low, int high)
	{    
		if(root==null) return null;
		// less than lower limit so move right
		if(low>root.val){
			return trimTree(root.right,low,high);
		}
		// more than higher limit so move left
		if(high<root.val){ 
			return trimTree(root.left,low,high);
		}
		// if within range build tree
		if(low<=root.val && root.val<=high){
			root.left = trimTree(root.left,low,high);
			root.right  = trimTree(root.right,low,high);
		
		}
		return root;
    }
}

}
