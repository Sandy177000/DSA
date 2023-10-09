public class pair_withgiven_sum {
    


	
    public void targetSum(Node root, int tar)
    {
		TreeMap<String, List<Integer>> map = new TreeMap<>();
		solve(root, root, tar, map);

		boolean flag  = false;
		
		for(String key:map.keySet()){
			List<Integer> list = map.get(key);
			System.out.println(list.get(0)+" "+ list.get(1));
			flag = true;
		}

		if(!flag) System.out.print(-1);
		

		
    }

	public boolean find(Node root, int tar){
		if(root==null) return false;
		if(root.data>tar){
			return find(root.left, tar);
		}
		else if(root.data<tar){
			return find(root.right, tar);
		}
		else{
			return true;
		} 
	}
	public void solve(Node root, Node node, int x,TreeMap<String,List<Integer>> map)
	{
		if(node==null) return;
		solve(root, node.left, x,map);
		if(find(root,x-node.data))
		{
			int a = node.data;
			int b = x - node.data;			
			if(a<=b){
				String key = a+""+b;
				if(!map.containsKey(key)){
					List<Integer> list = new ArrayList<>();
					list.add(a);
					list.add(b);
					map.put(key,list);
				}
			}
		}
		solve(root, node.right,x,map);
	}
}
