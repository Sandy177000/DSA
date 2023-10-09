public class two_sum {
    
	public static boolean solve(Node root, Node node, int k ){

		if(node==null){ return false;}
		
		if(find(root,k-node.val)){
			return true;
		}
		 return solve(root,node.left,k)||solve(root,node.right,k);

		
	}

	public static boolean find(Node root, int target){

		if(root==null) return false;

		if(root.val>target){
			return find(root.left,target);
		}
		else if(root.val<target){
			return find(root.right,target);
		}

		else{
			return true;
		}
		
		

	}
}
