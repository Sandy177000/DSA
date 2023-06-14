public class rotate_array {
    void leftRotate(long arr[], int k,int n)
    {
        k = k%n;
        if(k<0){
            k+=n;
        }
        
        //reversed complete array 0 to n-1
        reverse(arr,0,n-1);
        
        // reversed n-k elements
        reverse(arr,0,n-k-1);
        
        // reversed n-k to n-1 elements
        reverse(arr,n-k,n-1);
        
    }
    
    void reverse(long arr[], int start, int end){
        
        while(start<=end){
            long temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    } 

    public void rightrotate(int[] arr, int k) {
        int n = arr.length;

        k = k%n;
        //reversed complete array
        reverse(arr,0,n-1);

        // reverse first k elements
        reverse(arr,0,k-1);

        //reverse remaining elements
        reverse(arr,k,n-1);
    }

    public void reverse(int arr[], int start, int end){
      while(start<end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
      }
    }
}
