public class find_path_root_to_node {
    
class Solution{
	
	public boolean solve1(Node root,int b, ArrayList<Integer> list){

		if(root==null) return false;

		list.add(root.data);
		if(root.data == b){
			return true;
		}
		if(solve1(root.left,b,list) || solve1(root.right,b,list)){
			return true;
		}
		list.remove(list.size()-1);
		return false;
		
	}
	
   public ArrayList<Integer> solve(Node root,int b)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if(root==null) return list;	
		solve1(root, b, list);
		return list;     
    }
}

}
