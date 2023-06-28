
/************************TRICKY QUESTION***************************/

public class first_and_last_pos {
    
    public int[] searchRange(int[] nums, int target) {

        int arr[] = new int[2];
        if(nums.length==1 && target!=0)
        {
            arr[0] = 0;
            arr[1] = 0;
            return arr;
        }

        int first = firstpos(nums,target);
        int last  = lastpos(nums,target);
        
        arr[0] = first;
        arr[1] = last;

        return arr;
    }

    // binary search

    public static int lastpos(int nums[], int target){
        // returns index of the last occurence
       int n = nums.length;
       int low = 0;
       int high = n-1;
        
        while(low<=high){
            
            int mid = (low + high)/2;
            
            if(nums[mid]<target){
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                //corner case 
                if(mid==n-1){
                    return mid;
                }

                //check if next element is diffrent
                if(nums[mid+1]!=nums[mid]){
                    return mid;
                }
                //else search in right half
                else{
                    low = mid+1;
                }
            }
        }

        return -1;
    }

    public static int firstpos(int nums[], int target){
        // returns index of the first occurence
        
       int n = nums.length;
       int low = 0;
       int high = n-1;
      
        
        while(low<=high){
            
            int mid = (low + high)/2;
            
            if(nums[mid]<target){
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                // corner case
                if(mid==0){
                    return mid;
                }
                //check if prev element is same
                
                if(nums[mid-1]!=nums[mid]){
                    return mid;
                }
                
                //search in left half
                else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}

