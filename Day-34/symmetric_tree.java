public class symmetric_tree {
    
	public static boolean solve(Node root){
		
		Queue<Info> queue = new LinkedList<>();
		HashMap<Integer,Node> map = new HashMap<>();

		queue.add(new Info(root, 0));
		while(!queue.isEmpty()){
			for(int i=0;i<queue.size();i++)
			{
			    Info curr = queue.remove();

				// storing in the node and the its horizontal distance
				if(!map.containsKey(curr.hd))
				{
					map.put(curr.hd, curr.node);
				}

				// checking if the node at the opposite center and the curr node has same data
					if(map.containsKey(-curr.hd))
					{
						Node temp = map.get(-curr.hd);
						if(temp.data!=curr.node.data){
							return false;
						}
					}
				

				if(curr.node.left!=null) queue.add(new Info(curr.node.left,curr.hd-1));
				if(curr.node.right!=null) queue.add(new Info(curr.node.right,curr.hd+1));
				
			}
		}

		return true;

	}
}
