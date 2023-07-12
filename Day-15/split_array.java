public class split_array {
    
    public int splitArray(int[] nums, int k){

        int low = Integer.MIN_VALUE;// least sum of subarray

        int high = 0;// max sum of subarray

        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high+= nums[i];
        }

        while(low<=high){
            int mid = (low+high)/2;
            int parts = possible(nums, mid);
            if(parts>k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return low;
    }

    public int possible(int arr[], int sum){

          int sub_sum = 0;
          int parts = 1;
          for(int i=0;i<arr.length;i++){
              if(sub_sum+arr[i]<=sum){
                  sub_sum+=arr[i];
              }
              else{
                  parts++;
                  sub_sum = arr[i];
              }
          }    

          return parts;
    }
}    
