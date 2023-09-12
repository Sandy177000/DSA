public class rotten_oranges {
    class Solution {
        public int orangesRotting(int[][] grid) 
        {
              // storing all the rotten oranges points in the queue
                  
              Queue<int[]> queue = new LinkedList<>();
              int oranges = 0;
    
              for(int i=0;i<grid.length;i++){
                  for(int j=0;j<grid[0].length;j++){
                      if(grid[i][j]==2){
                          // pushing the points in queue
                          queue.add(new int[]{i,j});
                      }
    
                      if(grid[i][j]!=0){
                          oranges++;
                      }
                  }
              }    
    
              // no oranges case
              if(oranges==0){
                  return 0;
              }
    
              // search for rotten orange and mark its adjacent oranges as rotten
              int[] dx = {0,0,1,-1};
              int[] dy = {1,-1,0,0};
    
              int time = 0;
              int countOranges = 0;
              int row = grid.length;
              int col = grid[0].length;
    
            while(!queue.isEmpty())
            {
    
                  int size = queue.size();
                  countOranges += size;
    
                  // pick up the points from  queue
                  for(int i=0;i<size;i++)
                  {
                        int[] points = queue.poll();
    
                        for(int j=0;j<4;j++)
                        {
                            // calculating the coordinates
                            int x = points[0] + dx[j];
                            int y = points[1] + dy[j];
    
                            if(x>=row || y>=col || x<0 || y<0 || grid[x][y] ==0 || grid[x][y] ==2) continue;
    
                            // mark it as rotten
                            grid[x][y] = 2;
    
                            // pushing the coordinate in the queue
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
