public class right_view_of_binary_tree {
    
class Info{

	Node node;
	int vd;
	Info(Node n, int v){
		node = n;
		vd = v;
	}
}

class Solution{
    ArrayList<Integer> rightView(Node root) 
	{
        // level-order traversal
		Queue<Info> queue = new LinkedList<>();
		HashMap<Integer, Node> map = new HashMap<>();

		queue.add(new Info(root,0));

		while(!queue.isEmpty()){

			for(int i = 0;i<queue.size(); i++)
			{
				Info curr = queue.remove();

				// storing the node in the map
				if(!map.containsKey(curr.vd)){
					map.put(curr.vd, curr.node);
				}
				

                // traverse right instead of left first
				if(curr.node.right!=null){
					queue.add(new Info(curr.node.right,curr.vd+1));
				}
				
				if(curr.node.left!=null){
					queue.add(new Info(curr.node.left,curr.vd+1));
				}
				
				
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for(int i: map.keySet()){
			ans.add(map.get(i).data);
		}
		return ans;
    }
}
}
