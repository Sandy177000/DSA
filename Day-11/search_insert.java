
public class search_insert {
    public int searchInsert(int[] nums, int target) {
          
        int low = 0;
        int high = nums.length-1;
        int pos = 0;
        

        while(low<=high){
            int mid = (low + high)/2;

            if(nums[mid]>=target)
            {  
                high = mid-1;
            }

            else if(nums[mid]<target)
            {   
                
                low = mid + 1;
                pos = low;
            }

        }

        return pos;
    }
}
