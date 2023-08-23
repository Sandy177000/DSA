public class minimum_len_of_subarray_with_sum {


    // sliding window O(N) is better than hashmaps

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            
                int i=0;
                int j = 0;
    
                int n = nums.length;
    
                int sum  = 0;
                int len  = Integer.MAX_VALUE;
    
                while(j<n)
                {
                    sum+=nums[j];
                    while(sum>=target){
                        len = Math.min(len,j-i+1);
                        sum-=nums[i];
                        i++;
                    }
    
                    j++;
                }
    
                return len<Integer.MAX_VALUE? len:0;
        }
    }
}
