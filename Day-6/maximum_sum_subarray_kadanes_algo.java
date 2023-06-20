
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

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        //Kadane's Algorithm -2
        int max = nums[0];
        int curr_sum = nums[0];

        for(int i=1;i<n;i++){
            // check if adding next number to curr_sum it increases or decreases
            // if increases then add it to the curr_sum else start new subarray 
            
            curr_sum = Math.max(curr_sum + nums[i], nums[i]);
            max = curr_sum;
        }

        return max;

    }
    
}