public class nqueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) 
        {
            List<List<String>> ans = new ArrayList<>(n*n);
            solve(new boolean[n][n],0,ans);
            return ans;
        }
    
        
    
         public void solve(boolean[][] board, int row,List<List<String>> ans)
        {
    
            if(row==board.length)
            {   
                rowConvertor(board,ans);
                return;
            }
    
            for(int i=0;i<board.length;i++)
            {
                if(isSafe(board,row,i))
                {
                  board[row][i] = true;
                  solve(board,row+1,ans);
                  board[row][i] = false;
                }
            }
    
        }
        public void rowConvertor(boolean[][] board,List<List<String>> ans)
       {
    
           List<String> list = new ArrayList<>();
           for(int i = 0;i<board.length;i++ ){
            String x = "";
                for(int j = 0;j<board[0].length;j++ ){
                    if(board[i][j]){
                        x+="Q";
                    }
                    else{
                        x+=".";
                    }
                } 
           list.add(x);
    
           }
           ans.add(list);
    
       }
    
        public boolean isSafe(boolean board[][], int row, int col)
        {
            for(int i=0;i<row;i++){
                if(board[i][col])
                {
                    return false;
                }
            }  
            
            for(int i=1;i<=Math.min(row,col);i++){
                if(board[row-i][col-i])
                {
                    return false;
                }
            }
            
            for(int i=1;i<=Math.min(row,board.length-col-1);i++){
                if(board[row-i][col+i])
                {
                    return false;
                }
            }
            
            return true;
        }
    }   
}
