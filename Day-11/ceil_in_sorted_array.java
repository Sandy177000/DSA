
public class ceil_in_sorted_array {

    // index of ceil value - a min value which is greater than or equal to target
    static int findCeil1(long arr[], int n, long x)
    {
        int low = 0;
        int high = n-1;
        
        if(arr[0]>x){
            return 0;
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
        
        return low; // if ceil value is not found return low
    }


    static int findCeil(long arr[], int n, long x)
    {
        int low = 0;
        int high = n-1;
        int pos = -1;

        while(low<=high){
            int mid = (low+high)/2;
            
            if(arr[mid]>=x){
                pos = mid;
                high = mid-1;
            }
            else if(arr[mid]<x){
                low = mid+1;
            }
        }
        
        return pos;
}
}