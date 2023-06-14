
public class binary_search {
    static int searchInSorted(int arr[], int N, int K)
    {
        //Binary Search
        int start = 0;
        int end = N-1;
        
        while(start<=end){
            int mid = start +(end-start)/2;
            
            if(arr[mid]==K){
                return 1;
            }
            else if(arr[mid]>K){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        
        return -1;
    }
}
