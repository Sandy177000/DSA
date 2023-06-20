import java.util.*;

public class majority_element {
    public int majorityElement(int[] nums) {
        // two pointer method same starting point

        //sort the array
        Arrays.sort(nums);

        int i =0;
        int j =0;

        int n = nums.length;

        int count = 0;

        while(i<n){

            if(nums[i]==nums[j]){

                count++;
                // check count
                if(count>n/2){
                    return nums[i];
                }

                // move to next element
                j++;
            }
            else{
                // if not equal reset the count to zero 
                count = 0;
                // jump the start-index i to end-index j
                i = j;
            }
        }
        
        return 0;

    }
    // Return index of the majority element

     public int majorityElement2(int[] nums) {

        // find the majority element index
        int majority_idx = 0;
        int count1 = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[majority_idx] == nums[i]){
                count1++;
            }
            else{
                count1--;
            }
            
            if(count1==0){
                // this indicates that there exists another majority element 
                majority_idx = i;
                //reset count 
                count1 = 1;
            }
        }

        // check if the majority element is greater than nums.length/2
        int actual_count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[majority_idx]==nums[i]){
                actual_count++;
            }
        }

        if(actual_count<=nums.length){
            return -1;
        }

        return majority_idx;
     }
}
