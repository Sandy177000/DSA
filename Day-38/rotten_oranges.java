public class rotten_oranges {

    class Solution{        
         public static int orangesRotting(int[][] grid) 
        {
            //storing the coordinates of the rotten oranges in the queue
            Queue<int[]> queue = new LinkedList<>();
    
            int oranges = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==2){
                        // pushing the values in queue
                        queue.add(new int[]{i, j});
                    }
                    if(grid[i][j]!=0){
                        oranges++;
                    }
                }
            }
    
    
            // no oranges found 
            if(oranges==0)
            {
                return 0;
            }
            
            // search for rotten oranges and mark the oranges next to it as 2 (rotten)
    
            int countOranges = 0;
            int time = 0;
    
            int dx[] = {0,0,1,-1};
            int dy[] = {1,-1,0,0};
    
            int row = grid.length;
            int col = grid[0].length;
    
            while(!queue.isEmpty())
            {
                int size = queue.size();
                countOranges+= size;
                for(int i=0;i<size;i++)
                {
                    // picking up the first pair of coordinates from the queue
                    int[] coordinates = queue.poll();
                    for(int j=0;j<4;j++)
                    {
                        //calculating all the neighbouring coordinates
                        int x = dx[j] + coordinates[0];
                        int y = dy[j] + coordinates[1];
    
                        if(x<0 || y<0 || x>=row || y>=col || grid[x][y] == 0 || grid[x][y] == 2) continue;
    
                        // marking the oranges rotten
                        grid[x][y] = 2;
                        // pushing the coordinates to the queue
                        queue.offer(new int[]{x,y});
            
                    }
                }
    
                if(queue.size()!=0){
                    time++;
                }
                
            }
    
            if(oranges==countOranges){
                return time;
            }
    
            return -1;
            
        }
    }
       
}
