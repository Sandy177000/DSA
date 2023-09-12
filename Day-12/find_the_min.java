public class find_the_min {
    //binary search in rotated sorted array
    int findMin(int arr[], int n)
    {
        //complete the function here
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        
        while(low<=high){
            int mid = (low + high)/2;
            
               
            if(arr[mid]>=arr[low]){
                // left part sorted or not
                
                min = Math.min(arr[low], min);
                low = mid+1;// move to the right part
            }
            else{
                
                min = Math.min(arr[mid], min);
                high = mid-1;// move to the left part
            }
        }
        return min;
        
    }

    // array with duplicates
    class Solution {
        public int findMin(int[] nums) {
            
            int low = 0;
            int high = nums.length-1;
            int min = Integer.MAX_VALUE;
            while(low<=high)
            {
                int mid = (low + high)/2;
    
                if(nums[mid]==nums[low] && nums[mid]==nums[high]){
                    //shrink the search area
                    min = Math.min(min,nums[mid]);
                    low++;
                    high--;
                    continue;
                }
    
                if(nums[mid]>=nums[low]){
                    min = Math.min(min,nums[low]);
                    low = mid+1;
                }
                else{
                    min = Math.min(min,nums[mid]);
                    high = mid-1;
                }
            }
    
            return min;
        }
    }
}

