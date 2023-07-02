public class floor_in_sorted_array {
    // index of floor value
    static int findFloor(long arr[], int n, long x)
    {
        int low = 0;
        int high = n-1;
        int pos = -1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(arr[mid]>x){
                high = mid-1;
            }
            else if(arr[mid]<=x){
                
                low = mid+1;
                pos= mid;
            }
        }
        
        return pos;
    }
}
