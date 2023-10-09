public class construct_bst_level_order {
    class Pair{
		int lower;
		int upper;
		Node parent;
		Pair(Node parent,int lower, int upper){
			this.lower= lower;
			this.upper = upper;
			this.parent = parent;
		}
	}
	
	Node bstFromLevel(int arr[], int n) 
	{
		if(n==0) return null;
		
		Queue<Pair> queue = new LinkedList<>();
		Node root = new Node(arr[0]);
		queue.add(new Pair(root,Integer.MIN_VALUE, root.data-1));
	    queue.add(new Pair(root,root.data+1, Integer.MAX_VALUE));
	    int idx = 1;

		while(!queue.isEmpty()){
			Pair curr = queue.remove();
			if(idx==n) continue;

			// skip if the element does not lie in the range
			if(arr[idx] < curr.lower || arr[idx] > curr.upper) continue;

			// create a node
			Node node = new Node(arr[idx]);
			idx++;

			// attach at left or right
			if(node.data< curr.parent.data){
				curr.parent.left = node;
			}
			else{
				curr.parent.right = node;
			}

			// push new node in the queue with the limits
			queue.add(new Pair(node,curr.lower,node.data-1));
			queue.add(new Pair(node,node.data+1, curr.upper));
			
		}

		return root;
		
    }
}
