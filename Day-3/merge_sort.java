//TC = O(nlogn)
//SC = O(n)
//Adaptive = No
//Stable = Yes

public class merge_sort {
    public static void mergesort(int arr[], int l, int r) {
		
		// Step 0: Base case
		if(l>=r){
			return;
		}
    
       //Step:1 Divide the array into two parts find the mid index
		int mid = l+(r-l)/2;
		
		//Step 2: Recursively call the function to deal with two parts left and right
		mergesort(arr,l,mid);
		mergesort(arr,mid+1,r);

		//Step 3: Sort and Merge the Divided array elements
		merge(arr,l,mid,r);
		
    }
	public static void merge(int arr[], int start, int mid, int end){
		
		int temp[] = new int[end-start+1];
		
		int i = start; // start index of left part of array 
		int j = mid+1; // start index of right part of array 
		int k = 0;     // start index for temp array
		
		while(i<=mid && j<=end){
			if(arr[i]<arr[j]){
				temp[k] = arr[i];
				i++;
			}
			else{
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		// remaining elements of left part
		while(i<=mid){
			temp[k++] = arr[i++];
		}
		
		// remaining elements of right part
		while(j<=end){
			temp[k++] = arr[j++];
		}

		 // copy elements in original array
		 i = start;
		for(k=0; k<temp.length;k++){
			arr[i] = temp[k];
			i++;
		}
	}
}
