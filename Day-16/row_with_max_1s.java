
public class row_with_max_1s {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int max = 0;
        int arr[] = new int[2];

        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(max<count){
                max = count;
                arr[0] = i;
            }
        }
        arr[1] = max;
            
        return arr;

    }
}
