public class nearest_ones_in_matrix {
public class Main
{
	public static class Pair
	{
		int i;
		int j;
		int dist;
		Pair(int i, int j, int dist){
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
	
    //similar to rotten oranges BFS 
    public static int[][] nearest(int[][] grid)
    {
        // go to all the zeros and do bfs for 1
		Queue<Pair> q = new LinkedList<>();	
		int[][] vis = new int[grid.length][grid[0].length];
		
		for(int i =0;i<grid.length;i++){
			for(int j = 0;j<grid[0].length;j++){
				if(grid[i][j]==1){
					q.add(new Pair(i,j,0));
					vis[i][j] = 1;
				}
				else{
					vis[i][j] = 0;
				}
			}
		}
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		int[][] ans = new int[grid.length][grid[0].length];
		while(!q.isEmpty())
		{
			Pair curr = q.remove();
			ans[curr.i][curr.j] = curr.dist; // store the distance
			for(int l =0;l<4;l++){
				int x = curr.i + dx[l];
				int y = curr.j + dy[l];
				if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && (grid[x][y]==0)&& vis[x][y]==0){
					vis[x][y] = 1;
					q.add(new Pair(x,y,curr.dist+1)); // push the neighbour in queue if it is not visited earlier and increase the dist by one
				}
			}
			
		}

		return ans;
		
    }


}}
