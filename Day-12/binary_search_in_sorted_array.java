/********************TRICKY QUESTION***********************/
public class binary_search_in_sorted_array {
    
    public int search(int[] nums, int target) {
      
      int low = 0;
      int high = nums.length-1;

      while(low<=high){
          int mid = (low+high)/2;

          if(nums[mid]==target){
              return mid;
          }

          if(nums[low]<nums[mid])// check if left part is sorted
          { 
              if(target<nums[mid] && target>=nums[low]){ // check if target lies in between low and mid
                  high = mid-1; // ignore right part
              }
              else{
                  low = mid+1;// ignore left part
              }
          }
          else{// check if target lies in between mid and high
          
              if(nums[high]==target){//corner case
                  return high;
              }
              if(nums[mid]<target && nums[high]>=target){
                  low = mid+1;
              }
              else{
                  high = mid-1;
              }
          }
      }

      return -1;
    }
}
    
