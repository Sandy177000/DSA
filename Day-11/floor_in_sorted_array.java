public class floor_in_sorted_array {
    // index of floor value a max value less than equal to given target
    static int findFloor(long arr[], int n, long x)
    {
        int low = 0;
        int high = n-1;
        int pos = -1;

        // if target is greater than all the elements in the sorted array
        if(x>arr[n-1]){
            return n-1;
        }
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(arr[mid]>x){
                high = mid-1;
            }
            else if(arr[mid]<x){
                
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        
        return high; // if floor value is not found 
    }
}
