public class binary_search_in_array_with_duplicates {
    
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (low +high)/2;

            if(nums[mid]==target){
                return true;
            }
            if(nums[low]<nums[mid]){
                
                if(nums[mid]>target && target>=nums[low]){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[low]>nums[mid]){

                if(nums[mid]<target && target<=nums[high]){
                    low = mid +1;
                }
                else{
                    high = mid -1;
                }
            }
            
            else{
                low++;
            }
        }
        return false;
    }
}
