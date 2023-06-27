public class count_inversions {

    // applying the merge sort algo O(nlogn)

    static long inversionCount(long arr[], long N)
    {  
        int start = 0 ;
        int end = (int) N -1 ;
        return mergesort(arr,start,end);
        
    }
    
    static long mergesort(long arr[], int start, int end){
        
        // declare the count 
        long count = 0;
        
        if(start>=end){
            return count;
        }
        
        int mid = start + (end - start)/2;
        
        // add into the count returned by the left part
        count+=mergesort(arr, start, mid);
        
        // add into the count returned by the right part
        count+=mergesort(arr, mid+1, end);
        
        // add into the count returned while merging 
        count+=merge(arr, start, mid, end);
        
        // return count
        return count;
        
        
    }
    
    static long merge(long arr[], int start, int mid, int end){
         long temp[] = new long[end - start+1];
        
         int i = start;
         int j = mid+1;
         int k = 0;
         // Intialize the count 
         long count = 0;
         
         while(i<=mid && j <=end){
             if(arr[i]>arr[j]){
                 temp[k] = arr[j];
                 j++;
                 // count only when element in the left part is greater than right
                 count += mid - i +1;
             }
             else{
                 temp[k] = arr[i];
                 i++;
             }
             k++;
         }
         
         while(i<=mid){
             temp[k] = arr[i];
             k++;
             i++;
         }
         
         while(j<=end){
             temp[k] = arr[j];
             k++;
             j++;
         }
         i = start;
         for(int l=0 ; l<temp.length;l++){
             arr[i] = temp[l];
             i++;
         }
         
         // return the count
         return count;
    }
/************************ brute force ********************************/
 static long inversionCount2(long arr[], long N)
    {
        
        long count = 0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        
        return count;
    }
    
}
