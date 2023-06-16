public class rotate_matrix {
    // inplace algorithm

        public void rotate(int[][] matrix) {
        int n = matrix.length;

        //transpose of the matrix;

        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                if(i>j){
                    
                     int temp = matrix[i][j];
                     matrix[i][j] = matrix[j][i];
                     matrix[j][i] = temp;
                }
            }
            
        }

        // reverse each rows of matrix
        // two pointer method
        
        for(int i=0;i<n;i++){
            int left = 0;
            int right = n-1;

            while(left<right)
            {   
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }

        }
    }
}
