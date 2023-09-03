public class find_lowest_common_ancestor {
    
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
