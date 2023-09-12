public class construct_tree_pre_inorder {
    
class Solution{
	// preorder = root left right
	// inorder = left root right
	// postorder = left right root
	
    public static Node buildTree(int inorder[], int preorder[], int n){

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int  i=0;i<n;i++){
			map.put(inorder[i],i);
		}

		return builder(inorder, 0,n-1, preorder,0,n-1,map);
		
    }

	public static Node builder(int[] inorder, int in_start, int in_end, int[] pre, int pre_start,int pre_end, HashMap<Integer, Integer> map)
	{
		if(in_start>in_end && pre_start > pre_end) return null;
		
		 Node root = new Node(pre[pre_start]);
		 int index = map.get(root.data);
		 int numsLeft = index - in_start;
		 root.left = builder(inorder,  in_start,  index-1,  pre,   pre_start+1  ,         pre_start+numsLeft   ,map);
	  	 root.right = builder(inorder, index+1,   in_end,   pre,   pre_start+numsLeft+1 , pre_end        ,map);

		return root;
		
	}
}
}

