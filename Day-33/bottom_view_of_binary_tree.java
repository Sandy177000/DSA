public class bottom_view_of_binary_tree {
    
    // to store the distance and the node
class Info{
	Node node;
	int hd;

	public Info(Node n, int horizontaldist){
		this.node = n;
		this.hd = horizontaldist;
	}
}


class Solution{
    public ArrayList <Integer> bottomView(Node root)
    {
        
        //  level order traversal approach

		Queue<Info> queue = new LinkedList<>(); // to store the nodes of each level
		TreeMap<Integer, Node> map = new TreeMap<>(); // to store the distances in order
		ArrayList<Integer> list  = new ArrayList<Integer>(); // to store the answers
		
		queue.add(new Info(root,0));
		
		while(!queue.isEmpty())
		{
			for(int i=0;i<queue.size();i++)
			{
				Info curr  = queue.remove();

            
                // only change in top view and bottom view of binary tree 
				map.put(curr.hd, curr.node);
				
	
				if(curr.node.left!=null)
				{
					queue.add(new Info(curr.node.left, curr.hd-1)); // push new left node and its distance object in queue
				}
				if(curr.node.right!=null)
				{
					queue.add(new Info(curr.node.right, curr.hd+1));
				}
			}

		}

        // transfering the values to list from the tree map
		for(int i :map.keySet()){
			 list.add(map.get(i).data);
		}

		return list;
    }
}

}
