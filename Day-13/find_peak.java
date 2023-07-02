//*******************TRICKY QUESTION*******************************/

public class find_peak {
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
}
