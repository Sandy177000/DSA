public class set_to_zero {
     public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        boolean mat[][] = new boolean[row][col];

        //mark the zero elements to be visited
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                if(matrix[i][j]==0){
                    mat[i][j] = true;
                }
            }
        }


        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                //select only those zeros which were present in original matrix
                if(matrix[i][j]==0 && mat[i][j]==true){

                    for(int k=0;k<col;k++){
                        matrix[i][k] = 0;
                        
                    }

                    for(int l=0;l<row;l++){
                        matrix[l][j] = 0;
                        
                    }
                }
            }
        }
    }

}
