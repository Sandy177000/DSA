public class hamiltonian_path {
    

class Solution {

	static boolean flag = false;
	void dfs(ArrayList<ArrayList<Integer>> graph,int src, boolean[] vis, ArrayList<Integer> path)
	{
		path.add(src);
		vis[src] = true;
		if(path.size()==graph.size()-1){
			flag = true;
		}
		for(int nbr: graph.get(src))
		{	
			if(!vis[nbr]){
				dfs(graph,nbr,vis,path);
			}
		}
		vis[src] = false;
		path.remove(path.size()-1);
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {

		// make graph
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<=N;i++) graph.add(new ArrayList<>());
		for(ArrayList<Integer> edge: Edges)
		{
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		// dfs and count print path if nodes in path are N
		ArrayList<Integer> path = new ArrayList<>();
		boolean[] vis = new boolean[N+1];

		// checking all the nodes if continuous path covering all the nodes is possible
		for(int i = 1;i<=N;i++)
			dfs(graph,i,vis, path);

		return flag;
    
    }
}
}
