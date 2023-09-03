public class vertical_traversal {

    

class Info{
	TreeNode node;
	int hd;
	Info(TreeNode n, int h){
		hd  = h;
		node = n;
	}
}
class Solution {
    List<List<Integer>> VerticalTraversal(TreeNode root) 
	{
        // level-order traversal
        
		Queue<Info> queue = new LinkedList<>();
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		queue.add(new Info(root,0));
		
		while(!queue.isEmpty())
		{
			for(int i=0;i<queue.size();i++)
			{
				Info curr = queue.remove();

				// adding the nodes of same horizontal distance in a list in the map
				if(map.containsKey(curr.hd))
				{
					List<Integer> list = map.get(curr.hd);
					list.add(curr.node.data);
					map.put(curr.hd, list);
				}
				else{
					List<Integer> list = new ArrayList<Integer>();
					list.add(curr.node.data);
					map.put(curr.hd,list);
				}
				if(curr.node.left!=null)
				{
					queue.add(new Info(curr.node.left, curr.hd-1));	
				}
				if(curr.node.right!=null)
				{
					queue.add(new Info(curr.node.right, curr.hd+1));	
				}		
			}
		}
		List<List<Integer>> ans = new ArrayList<>();
		for(int i: map.keySet()){
			ans.add(map.get(i));
		}
		return ans;
    }
}

}
