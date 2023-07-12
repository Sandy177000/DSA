public class binary_search2_in_2d_array {
    
       
        public boolean searchMatrix1(int[][] matrix, int target) {
            int i=0;
            int j=matrix[0].length-1;
            while(j>=0&&i<matrix.length){
                if(matrix[i][j] == target)return true;
                else if(target<matrix[i][j])j--;
                else i++;
            }
            return false;   
        }
    

        // less optimised
        public boolean searchMatrix2(int[][] matrix, int target) {
                for(int i = 0 ; i < matrix.length ; i++){
                    if(bSearch(matrix,target,i)) return true;
                }
                return false;
            }
            private boolean bSearch(int[][] nums,int target,int row){
                int s = 0;
                int e = nums[row].length-1;
                // int mid = (s+e)/2;
        
                while(s <= e){
                    int  mid = s + (e-s)/2;
                    if(nums[row][mid] == target){
                        return true;
                    }else if(nums[row][mid] < target){
                        s = mid+1;
                    }else{
                        e = mid-1;
                    }
            }
            return false;
        }

        // brute force : linear search
        
}
