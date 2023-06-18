public class rearrange_elements {

//------------if number of postives and negatives are not equal----------------

    void rearrange(int arr[], int n) {
        
        //count positive and negative elements
		int pos = 0;
		int neg = 0;
		
		for(int i=0;i<n;i++){
			if(arr[i]>=0){
				pos++;
			}
			else{
				neg++;
			}
		}
		
		// make arrays and store the positive and negative elements separately
		int posi[] = new int[pos];
		int nega[] = new int[neg];
		int pp = 0;
		int nn  = 0;
		
		for(int i=0;i<n;i++){
			if(arr[i]>=0){
				posi[pp] = arr[i];
				pp++;
			}
			else{
				nega[nn] = arr[i];
				nn++;
			}
		}

        // tricky part:

        // copy the elements from the positive and negative arrays alternatively
        // into the original array alternatively
		int k = 0;
		int lim = 2*Math.min(pos,neg); // limit upto which number of pos and neg values are same
		int ii = 0;
		int jj = 0;
        
		while(k<lim){
			if(k%2==0){
				arr[k] = posi[ii];
				ii++;
				pos--;
			}
			else{
				arr[k] = nega[jj];
				jj++;
				neg--;
			}
			k++;
		}
		
		// adding the leftover elements to array
		if(pos>0)
    		while(lim<n){
    			arr[lim] = posi[ii];
    			lim++;
    			ii++;

    		}

		if(neg>0)
    		while(lim<n){
    		
    			arr[lim] = nega[jj];
    			lim++;
    			jj++;
    		}
    }
    

//-------- If the number of positives and negatives are same ----------------

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        // make a new array

        int result[] = new int[n];
        int a = 0;
        int b = 1;

        for(int i=0;i<n;i++){
            //alternatively adding the positives and negatives
             if(nums[i]>0){
                 result[a] = nums[i];
                 a = a+2;  // Important step : Skipping index by 2
             }
             else{
                 result[b] = nums[i];
                 b = b+2;  // Important step : Skipping index by 2
             }
        }
       
        return result;
    }

}
