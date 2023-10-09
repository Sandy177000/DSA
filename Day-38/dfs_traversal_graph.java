public class dfs_traversal_graph {
    //recursive
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int node){

		vis[node] = true;
		System.out.print(node+" ");

        // for each neighbour of the curr node of the graph 
        // if it is not visited then search its neighbours again

		for(int nbr: graph.get(node)){
			if(!vis[nbr]) dfs(graph,vis,nbr); // searching for the neigbour of neighbours
		}
	}
}
