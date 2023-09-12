//*******************TRICKY QUESTION*******************************/

public class find_peak {

    //1d matrix
    public int peakElement(int[] arr,int n)
    {
       //corner cases
       if(n==1){
           return 0;
       }
       if(arr[0]>arr[1]){
           return 0;
       }
       if(arr[n-1]>arr[n-2]){
           return n-1;
       }

       //excluding cases
       
       int low = 1;
       int high = n-2;
       
       while(low<=high)
       {
           int mid = (low+high)/2;
           
           // if element at mid is greater than its neighbours then it is a peak
           if(arr[mid]>=arr[mid-1] && arr[mid] >=arr[mid+1]){
               return mid;
           }
           
           // fact: if prev element of the element at mid is less 
           //       then peak is likely not present in the left part so move to right
           
           if(arr[mid]>arr[mid-1]){
               low = mid+1;
           }
           else{
               high = mid-1;
           }
       }
       
       return 0;
       
    }    

    // 2d matrix
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            
    
            int low = 0;
            int high = mat.length-1;
    
            while(low<=high){
                int mid = (low+high)/2;
    
                int idx = 0;
    
                // linearly find the peak index
                for(int i= 0;i<mat[0].length;i++){
                    if(mat[mid][i]>mat[mid][idx]){
                        idx = i;
                    }
                }
    
                boolean top = true;
                boolean bottom = true;
    
                if(mid-1>=0){
                    if(mat[mid][idx]<mat[mid-1][idx]){
                        top = false;
                    }
                }
                
                if(mid+1<=mat.length-1){
                    if(mat[mid][idx]<mat[mid+1][idx]){
                        bottom = false;
                    }
                }
    
                if(top && bottom){
                    // peak found
                    return new int[]{mid,idx};
                }
                else if(top==false){
                    // go to top row
                    high = mid-1;
                }
                else{
                    // go to bottom row
                    low = mid+1;
                }
    
    
            }
            
                return null;
        }
    }
}

