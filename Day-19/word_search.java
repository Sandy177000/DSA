public class word_search {
    class Solution {
        public boolean exist(char[][] board, String word) {
           
           
           for(int i=0;i<board.length;i++)
           {
               for(int j=0;j<board[0].length;j++)
               {
                   if(board[i][j]==word.charAt(0)) // searching for the first character which matches with our word
                       if (search(board,word,0,i,j,board.length,board[0].length)) // searching for the word recursively
                           return true;
               }
           }
    
           return false;
    
        }
    
        public boolean search(char[][] board, String word,int index ,int x, int y, int r, int c)
        {
            //base case
            if(index==word.length()){
                return true;
            }
    
            // if we go out of the matrix boundaries 
            // or if the character in word does not match with our current position on the board
            if(x<0 || y <0 || x>r-1 || y>c-1 || word.charAt(index)!=board[x][y])
            {
                return false;
            }
            
            char ch  = board[x][y];
            board[x][y] = '#'; // marking the visited char in the matrix
    
            boolean right = search(board, word, index+1, x+1, y,r,c); // move right on the board
            boolean down = search(board, word, index+1, x, y+1,r,c); // down
            boolean left = search(board, word, index+1 ,x-1, y,r,c); // left
            boolean top = search(board, word, index+1, x, y-1,r,c); // top
    
            board[x][y] = ch; // restoring the character while backtracking
    
            return right || down || left || top;
           
        }
    }   
}
