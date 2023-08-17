public class path_with_max_gold {
    class Solution {


        public int getMaximumGold(int[][] grid) {
            
            int row = grid.length;
            int col = grid[0].length;
            return solve(grid,row,col);
    
        }
    
        public int solve(int[][] arr, int row, int col){
    
            int max = 0;
            for(int i =0;i<row;i++){
    
                for(int j = 0;j<col;j++)
                {
    
                    if(arr[i][j]!=0) // traverse through each element in matrix and find which is not zero
                    {
                        max = Math.max(max,findGoldPath(max,arr, new boolean[row][col],0, i,j)); // storing the all time max gold obtained from all positions
                    }
    
                }
            }
    
            return max;
        }
    
        // finds max gold starting from i j position
        public int findGoldPath(int max,int[][] arr, boolean[][] vis,int gold ,int row, int col)
        {
            if(row<0 || col<0 || row>arr.length-1 || col>arr[0].length-1 || arr[row][col]==0)//*** base***
            {   
                max = Math.max(gold, max);
                return max;
            }
    
            if(!vis[row][col])
            {
                vis[row][col] = true; // mark visited
                max = findGoldPath(max,arr, vis, gold+arr[row][col], row,col-1); // go left
                max = findGoldPath(max,arr, vis, gold+arr[row][col],row,col+1); // right
                max = findGoldPath(max,arr, vis, gold+arr[row][col], row-1,col); // top
                max = findGoldPath(max,arr, vis, gold+arr[row][col], row+1,col); // down
                vis[row][col] = false; // backtrack and mark not visited
            }
    
            return max;
    
    
            
        }
    }
}
