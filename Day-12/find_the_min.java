public class find_the_min {
    //binary search in rotated sorted array
    int findMin(int arr[], int n)
    {
        //complete the function here
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        
        while(low<=high){
            int mid = (low + high)/2;
            
               
            if(arr[mid]>=arr[low]){// left part sorted or not
                
                min = Math.min(arr[low], min);
                low = mid+1;// move to the right part
            }
            else{
                
                min = Math.min(arr[mid], min);
                high = mid-1;// move to the left part
            }
        }
        return min;
        
    }
}
