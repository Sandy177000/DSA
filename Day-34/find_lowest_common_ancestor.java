public class find_lowest_common_ancestor {

	
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if the root is null or one of the nodes is found, return root
        if(root == null || root == p|| root == q){
            return root;
        }
        //then we will search for the LCA in the left and right trees
        TreeNode left_search = lowestCommonAncestor(root.left,p,q);
        TreeNode right_search = lowestCommonAncestor(root.right,p,q);

        //if the left and right side are not null then that means one of the nodes in the left subtree. that means the current root is the LCA
        if(left_search != null && right_search != null){
            return root;
        }
        //if only one of them is not null, then return the non-null
        return (left_search != null) ? left_search : right_search;

       
    }

}
    
class Solution {
    public static Node findLCA(Node node,int n1,int n2) 
	{   
		ArrayList<Node> list1 = new ArrayList<>();
		findPath(node,n1,list1);
		ArrayList<Node> list2 = new ArrayList<>();
		findPath(node,n2,list2);

        // finding common node in the paths of the root to node
		Node ans = node;
		for(Node n:list1)
		{
			if(list2.contains(n)) ans = n;
		}
		return ans;	
    }
	
	public static boolean findPath(Node node, int target,ArrayList<Node> list)
	{
		if(node==null) return false;
		
		list.add(node);
		if(node.data==target) return true;

        // go left or right
		if(findPath(node.left,target,list)||findPath(node.right,target,list))
		{
			return true;
		}

        // backtrack
		list.remove(list.size()-1);

		return false;
	}
}
}
