public class left_view_of_binary_tree {
    
class Solution
{
    public static void letfView(Node root)
    {
		
        Queue<Info> queue = new LinkedList<>();
		TreeMap<Integer, Node> map = new TreeMap<>();
		queue.add(new Info(root,0));
		
		while(!queue.isEmpty())
		{
			for(int i=0;i<queue.size();i++)
			{
				Info curr = queue.remove();
				
				// this stores only those nodes which are on the same level		
				if(!map.containsKey(curr.vd))
				{
					map.put(curr.vd,curr.node);
				}
				
				if(curr.node.left!=null)
				{
					queue.add(new Info(curr.node.left, curr.vd+1));	
				}
				if(curr.node.right!=null)
				{
					queue.add(new Info(curr.node.right, curr.vd+1));	
				}		
			}
		}

		
		for(int i: map.keySet()){
		    System.out.print(map.get(i).data+" ");
		}
		
		
    }
    
    
}
}
