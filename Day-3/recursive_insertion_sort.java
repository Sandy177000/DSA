public class recursive_insertion_sort {
    //Function to sort the array using insertion sort algorithm.
    public void insertion(int arr[], int i, int n)
    {
        if(i>n-1){
            return;
        }
        for(int k =i-1;k>=0;k--){
            if(arr[k]>arr[k+1]){
                int temp = arr[k];
                arr[k] = arr[k+1];
                arr[k+1] = temp;
            }
        }
        
        insertion(arr, i+1, n);
    }
    
    public void insertionSort(int arr[], int n)
    {
        //code here
        int i = 1;
        insertion(arr,i,n);
        
    }
    
}
