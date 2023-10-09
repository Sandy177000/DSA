public class cycle_detection_DG {
    
class Solution {
	public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
    	boolean[] vis = new boolean[V];
		boolean[] path = new boolean[V];
		// checking for every vertices of the graph
		for(int i =0;i<V;i++){
			if(!vis[i]){
				if(dfs(vis,i,adj, path)) return true;
			}
		}
		return false;
   }

	public boolean dfs(boolean[] vis, int start,ArrayList<Integer>[] g,boolean[] path){{

		 path[start] = true;
		 vis[start] = true;

		for(int nbr: g[start]){
			if(path[nbr]) return true; // cycle found as the nbr is already visited before
			else if(!vis[nbr]){
				if(dfs(vis,nbr,g,path)) return true;
			}
			
		}

		// backtracking
		path[start] = false;
		return false;
	}
}
}
}
