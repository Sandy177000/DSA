public class sudoku {
    class Solution {
        public void solveSudoku(char[][] board)
        {
            solve(board);
        }
    
        public boolean solve(char[][] board)
        {    
            int n = board.length;

            // loop through the matrix
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    // fint the empty space to be filled
                    if(board[i][j]=='.'){
                        
                        // use a loop to try out each possibility from 1 to 9 and check it
                        for(char k='1';k<='9';k++){
                            if(isSafe(board,i,j,k))
                            {
                                board[i][j] = k; // is possible replace the "." with the value k

                                if(solve(board)){ // call the function to check whether by replacing above value sudoku is solved
                                    return true;
                                }
                                else{ // if it is not possible at any stage/level backtrack and replace the k value with the empty space and 
                                     // the loop continues trying for the remaining numbers
                                    board[i][j] = '.';
                                }
    
                            }
                        }
    
                        return false; // if the program completes the for loop and reaches this statement infers
                                      //  that the there is no solution possible as all the numbers are tried
                    }
                }
            }
    
            return true;// solution exists and is correct by default
        }
    
        public boolean isSafe(char[][] board, int row, int col, char value){
    
    
            for(int i=0;i<=8;i++){
                if(board[row][i]==value){
                    return false;
                }
                if(board[i][col]==value){
                    return false;

                }

                // tricky part
                if(board[(row/3)*3 + i/3][(col/3)*3 + i%3]==value){
                    return false;
                }
            }
    
            return true;
        }
    }
}
