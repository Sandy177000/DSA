public class number_of_distinct_islands {
    

public static int countDistinctIslands(int[][] grid) {
    // store paths in the hashset generated using dfs 
    // return size of the hashset
    
    HashSet<ArrayList<String>> set = new HashSet<>();
    int r = grid.length;
    int c = grid[0].length;
    
    for( int i = 0;i<r;i++){
        for(int j = 0;j<c;j++){
            if(grid[i][j]==1){
                ArrayList<String> path = new ArrayList<String>();
                dfs(grid,i,j,i,j,path);
                //dfs(grid,i,j,i,j,vis,path, set);
                set.add(path);
            }
        }
    }
    return set.size(); 
    
  }
  public static void dfs(int[][]grid ,int r0, int c0, int r, int c, ArrayList<String> path){
      if(r<0 || c<0 || r>grid.length-1 || c> grid[0].length-1 || grid[r][c]==0) return;
      // marking 0
      grid[r][c] = 0;
      // unique path key 
      String key = String.valueOf(r-r0) + String.valueOf(c-c0); 
      path.add(key);
      dfs(grid,r0,c0,r+1,c,path);
      dfs(grid,r0,c0,r,c+1,path);
      dfs(grid,r0,c0,r-1,c,path);
      dfs(grid,r0,c0,r,c-1,path);
  }


}