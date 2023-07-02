/************************TRICKY QUESTION*********************************/

public class find_non_repeated_element {
    
    int findOnce(int arr[], int n)
    {
         //edge cases
         if(n==1){
             return arr[0];
         }
         
         if(arr[0]!=arr[1]){
             return arr[0];
         }
         
         if(arr[n-1]!=arr[n-2]){
             return arr[n-1];
         }
         
         // excluding the first and the last element
         int low = 1;
         int high = n-2;
         
         while(low<=high){
             
             int mid = (low+high)/2;
             // checking if the mid element's neighbours are different
             if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1])
             {
                return arr[mid];   
             }
                
            // fact : at even mid index, mid element and its next element should be same or
            //        at odd mid index, mid element and the prev element should be same
            // only then we can say the element which we are looking for is in the right half of the array
            
            if( ( (mid%2!=0) && (arr[mid] == arr[mid-1]) ) || 
                ( (mid%2==0) && (arr[mid] == arr[mid+1]) ) 
              )
             {
                low = mid + 1; // move to right half
             }
             else
             {
                high = mid - 1; // move to left half
             }
             
         }
         
         return arr[low];
    }    
}
