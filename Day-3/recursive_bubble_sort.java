public class recursive_bubble_sort {
    //Function to sort the array using bubble sort algorithm.
    public static void recur_bubbleSort(int arr[], int n)
    {
        int i = 0;
        bubble(arr,i,n);
        
    }
    public static void bubble(int arr[], int i, int n){
        
        if(i>n-1){
            return;
        }
        
        for(int j=i;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        bubble(arr,i+1,n);
    }
}
