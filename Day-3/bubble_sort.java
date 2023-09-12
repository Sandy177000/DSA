// TC = O(n2) comparisons and swaps
// SC = O(1) extra space
// Stable
// Adaptive: O(n) when nearly sorted

public class bubble_sort {


//Optimised
    public static void bubbleSort(int arr[], int n)
    {
        boolean swapped = false;
        for(int i=0;i<n-1;i++)
        {
            swapped = false;
          
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
          
           if(swapped==false){
             // this means rest of the array is sorted no need to traverse further
             break;
            }
        }
    }

    
//brute force
public static void bubbleSort1(int arr[], int n)
    {
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
