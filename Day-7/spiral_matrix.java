import java.util.*;

public class spiral_matrix {
    

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        int top = 0;
        int right = matrix[0].length-1;
        int left = 0;
        int bottom = matrix.length-1;
         
        while(left<=right && top<=bottom){

         boolean flag = false;
          boolean flag1 = false;
           boolean flag2 = false;  

            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
                flag = true;
            }
            
            if(flag)
                {
                    for(int i=top+1;i<=bottom;i++){
                        list.add(matrix[i][right]);
                        flag1 = true;
                     }
                    
                }

            if(flag1){
                        
                    for(int i=right-1;i>=left;i--){
                        list.add(matrix[bottom][i]);
                        flag2 = true;
                    }

            }

            if(flag2){
                    
                for(int i=bottom-1;i>top;i--){
                    list.add(matrix[i][left]);
                    
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return list;
    }}
