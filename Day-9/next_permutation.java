public class next_permutation {
    // in place method 

        public void nextPermutation(int[] nums) {
        // nums : 2 1 5 4 3 0 0 

        int n = nums.length;
        // Find the breakpoint index
        // it is a point at which array is in ascending order
        
        int breakpoint = -1;
        for(int i= n-2; i>=0;i--){
            if(nums[i+1] > nums[i]){
                breakpoint = i;
                break;
            }
        }

        // breakpoint index = 1 as (1<5)

        // special case: if the array is already in descending order 
        // then simply return ascending order of the array by reversing it
        if(breakpoint==-1){
            int start = 0;
            int end = n-1;
            while(start<=end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        else{

            //Find the element in the array which is just greater than element at breakpoint
            // swap them

            for(int i=n-1;i>breakpoint;i--)
            {
                if(nums[i]>nums[breakpoint]){
                    int temp = nums[i];
                    nums[i] = nums[breakpoint];
                    nums[breakpoint] = temp;
                    break; //important step 
                }
            }

            // nums = 2 3 5 4 1 0 0
           
            // reverse the right side of breakpoint in the array 
            int start = breakpoint +1;
            int end = n-1;
            while(start<=end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

            // nums = 2 3 0 0 1 4 5 

        }


    }
    
}