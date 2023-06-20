import java.util.*;

public class longest_consecutive_seq {
     // TC = O(N) SC = O(N)

      public int longestConsecutive(int[] nums) {

       int n  = nums.length;

       if(n<=1){
           return n;
       }

       HashSet<Integer> set = new HashSet<Integer>();
       //unique set of elements
       for(int num:nums){
           set.add(num);
       }

       int maxlength = 1;
       int length = 0;

       for(int i=0;i<n;i++){
           if(!set.contains(nums[i]-1)){// if we are checking from 1 -> 2,3,4 to avoid rechecking 
                                        // from next element 2 for arr: {1,2,3,4,100,101}
               
               int curr_number = nums[i];
               length = 1;
               while(set.contains(curr_number+1)){
                   length++;
                   curr_number++;
               }
            
             maxlength = Math.max(length, maxlength);   
           }
       }

       return maxlength;

    }
    // brute force O(nlogn)

     public int longestConsecutive2(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        //sort the array
        Arrays.sort(nums);
        int n = nums.length;


        int prev= nums[0];
        int length = 1;
        int maxlength = 1;


        for(int i=1;i<n;i++){
            // next element should be +1 than previous then only increase the length
            if(nums[i]==prev+1){
                length++;
            }
            // else check if next element is not equal prev then reset the length
            else if(nums[i] != prev){
                length = 1;
            }
            prev = nums[i];// update prev by curr
            maxlength = Math.max(maxlength, length);
        }
        return maxlength;
    }
}
