public class target_sum {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) 
        {
            return helper(nums,0,0,target);
        }
    
        public int helper(int[] nums, int index, int sum,int target){
    
            if(index==nums.length){
                if(sum==target){
                    return 1; // valid way 
                }
                else{
                    return 0; // invalid way 
                }
            }
        
            int left = helper(nums, index+1, sum+nums[index],target); // add
            int right = helper(nums, index+1, sum-nums[index],target); // subtract
    
            return left + right; // total ways to get the sum
    
        }
    }
}
