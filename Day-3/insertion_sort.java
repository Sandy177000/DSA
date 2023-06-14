// TC = O(n2) comparisons and swaps
// SC = O(1) extra space
// Stable
// Adaptive: O(n) time when nearly sorted
// Very low overhead

public class insertion_sort {
    public void insertionSort(int arr[], int n)
  {
      //code here
      for(int i=1;i<n;i++){
          for(int j=i-1;j>=0;j--){
              if(arr[j]>arr[j+1]){
                  int temp = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = temp;
              }
          }
      }
  }
}
