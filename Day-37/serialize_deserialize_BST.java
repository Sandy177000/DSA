public class serialize_deserialize_BST {
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        //Write code here
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder str = new StringBuilder();
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode curr = queue.remove();

				if(curr==null){
					str.append("#"+" ");
					continue;
				}
				
					str.append(String.valueOf(curr.val)+" ");
					queue.add(curr.left);	
					queue.add(curr.right);

			}
		}

		return str.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str)
    {
		String[] values = str.split(" ");

		// beacuse it is preorder so starting value will be the root
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		for(int i=1;i<values.length;i++){

			TreeNode curr = queue.remove();

			// not null node add to left
			if(!values[i].equals("#"))
			{
					TreeNode left = new TreeNode(Integer.parseInt(values[i]));
				    curr.left = left;
				    queue.add(curr.left);
			}

			if(!values[++i].equals("#"))
			{
				    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
				    curr.right = right;
				    queue.add(curr.right);
			}
			
			
		}
		
		return root;
    }

}
