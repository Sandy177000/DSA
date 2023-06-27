import java.util.*;

public class all_subarrays_with_given_sum {
    //Refer to Day-7 prefix sum problem
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int n = nums.length;
        int prefix_sum = 0;
        int count = 0;
        // Initialize with zero sum occuring one time
        map.put(0,1);

        for(int i=0;i<n;i++){
        
            prefix_sum += nums[i];
            
            if(map.containsKey(prefix_sum - k)){
                // get the frequency of the difference from the map
                count = count + map.get(prefix_sum-k);
            }
            // store the prefix_sum upto index i
            map.put(prefix_sum, map.getOrDefault(prefix_sum,0)+1);         

        }   
        return count;


        /*
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int n = nums.length;
        int prefix_sum = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            prefix_sum += nums[i];
            if(prefix_sum == k){
                count++;
            }

            if(map.containsKey(prefix_sum - k)){
                count = count + map.get(prefix_sum-k);
            }

            if(!map.containsKey(prefix_sum)){
                map.put(prefix_sum,1);
            }
            else{
                map.put(prefix_sum, map.get(prefix_sum)+1);
            }

        }   

        return count;*/
    }

    //brute force
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
           
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int sum =0 ;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==s){
                    count++;
                }
            }
        }
        return count; 
    }
}

