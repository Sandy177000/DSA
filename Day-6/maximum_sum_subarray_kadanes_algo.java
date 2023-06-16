
public class maximum_sum_subarray_kadanes_algo {
        
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //Kadane's Algorithm
        int max = Integer.MIN_VALUE;
        int curr_max = 0;

        for(int i=0;i<n;i++){
            
            curr_max +=nums[i];
            if(curr_max>max)
            {   
                max = curr_max;    
            }
            // reset the curr max to 0 as we won't get max sum by including negative nums
            if(curr_max<0){
                curr_max = 0;
            }
        }

        return max;

    }
    
}