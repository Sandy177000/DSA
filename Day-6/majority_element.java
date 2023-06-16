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
}
