public class unique_paths {
    class Solution {
        public int uniquePathsIII(int[][] grid) {
            
            int srow = 0;
            int erow = 0;
            int scol = 0;
            int ecol = 0;
            int count = 0;
    
    
            for(int i =0;i<grid.length;i++)
            {
                 for(int j =0;j<grid[0].length;j++){
                     if(grid[i][j]==1){
                         // start found
                         srow = i;
                         scol = j;
                         count++;
                     }
                     if(grid[i][j]==0){
                         count++;
                     }
                 }
            }
            boolean[][] vis = new boolean[grid.length][grid[0].length];
            //[srow][scol] = true;
    
            return findPaths(count,grid,srow,scol,vis);
    
        }
        
        public int findPaths(int count ,int[][] grid, int i, int j, boolean[][] vis)
        {
    
            if(i<0 || i>grid.length-1 || j>grid[0].length-1 || j<0 || grid[i][j]==-1 || vis[i][j]) 
            { 
                return 0;
            }
            
            if(grid[i][j]==2)// reached destination
            {   
                if(count==0) // all the paths used
                {   
                    return 1;
                }
    
                return 0;
            }
    
            vis[i][j] = true;
            count-=1;// using the paths
            int down = findPaths(count,grid,i+1,j,vis);
            int right = findPaths(count,grid,i,j+1,vis);
            int up = findPaths(count,grid,i-1,j,vis);
            int left =  findPaths(count,grid,i,j-1,vis);
            vis[i][j] = false;
    
    
            return right+left+up+down;
    
        }
    
        
    }
    
}
