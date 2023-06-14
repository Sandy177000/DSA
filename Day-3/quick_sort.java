// TC = O(nlogn)
// SC = O(1)
// Adaptive = no
// Stable = no

public class quick_sort {

	static void quickSort(int[] arr, int start, int end)
	{
		   // Step 0: Base case
			if(start>=end){
				return;
			}
		   //Step 1:  find pivot index 
		   int pIdx = partition(arr,start,end);

		    //Step 2: Recursive quick sort calls to divide the array into two parts
		
		    // Note : end = pIdx -1 and pIdx + 1 because the element at pivot index 
		    // is already sorted no need to include that element
		
		    quickSort(arr,start,pIdx-1);
		    quickSort(arr,pIdx+1,end);
		
    }


	static int partition(int arr[], int start, int end){
		// Assume pivot point as last element of array
		int pivot = arr[end];
		int i = start-1;
		
		// check for the numbers less than pivot
		// in the given part (from start to end) of the array
		
		for(int j=start;j<end;j++){
			// put numbers less than pivot at the start of the array
			if(arr[j]<=pivot){
				 i++;
				//swap
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// to put pivot in its sorted place in array
		 i++;
		//swap
		int temp = pivot;
		arr[end] = arr[i];
		arr[i] = temp;

		return i;
		 
	}


}
