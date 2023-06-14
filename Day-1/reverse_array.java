
public class reverse_array {
    public static void revArray(int arr[], int start, int end){
      if(start==end || start>end){
        return;
      }
        //swap
        int t = arr[start];
        arr[start]=arr[end];
        arr[end] = t;

        revArray(arr,start+1,end-1);
    }

    
}