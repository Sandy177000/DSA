public class bfs_traversal_graph {
    
    //iterative similar to bfs of trees

    void BFS(int x) {
        //BFS-> queue DFS-> stack
		Queue<Integer> q = new LinkedList<>();
		q.add(x);// graph is starting from zero
		boolean[] vis = new boolean[this.vertices];

		while(!q.isEmpty())
		{
			int curr = q.remove();
            
			if(!vis[curr]){
				vis[curr] = true;
				System.out.print(curr+" ");
				// getting neighbour list of the curr node add them in the queue
				for(int nbr:adjList[curr]){
					q.add(nbr);
				}
			}
			
		}
		
    }

}
