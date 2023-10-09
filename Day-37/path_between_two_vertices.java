public class path_between_two_vertices {
    
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<N;i++){
			graph.add(new ArrayList<>());
		}

		for(ArrayList<Integer> edge:Edges){
			int x = edge.get(0)-1;
			int y = edge.get(1)-1;
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		return solve(graph,U-1,V-1,new boolean[N]);
		//return flag;
    }

	//static boolean flag = false;
	public static boolean solve(ArrayList<ArrayList<Integer>> graph, int start, int end, boolean[] vis){
		//bfs
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty())
		{
			int curr = q.remove();
			if(!vis[curr]) vis[curr] = true;
			for(int nbr:graph.get(curr)){
				if(nbr==end) return true;
				if(!vis[nbr]) q.add(nbr);
			}
		}
		return false;
    }
}
