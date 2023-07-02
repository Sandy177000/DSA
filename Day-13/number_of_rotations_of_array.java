
public class number_of_rotations_of_array {
    
    int findKRotation(int arr[], int n) {
        // find the minimum value index
        
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        int min_idx = 0;
        
        while(low<=high){
            int mid = (low + high)/2;
            
            // left part sorted or not
            if(arr[mid]>=arr[low]){
                //search for min in left part
                if(min>arr[low]){
                    min_idx = low;
                    min = arr[low];
                }
                // move to the right part
                low = mid+1;
            }
            else{
                //search in right part
                if(min>arr[mid]){
                    min_idx = mid;
                    min = arr[mid];
                }
                //move to the left part
                high = mid-1;
            }
        }
        return min_idx;
    }    
}
