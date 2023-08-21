import java.util.HashMap;

public class longest_subarray_of_sum_zero {
    //Prefix-Sum method TC O(N) SC O(N)

    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int curr_sum = 0;
        int maxlen = 0;
        int len = 0;
        
        for(int i=0;i<n;i++){
            curr_sum += arr[i];
            
            if(curr_sum==0){
                maxlen = Math.max(maxlen, i+1);
            }
            // if curr_sum - k already appeared in the array(map) previously
            // Calculate the diff of curr_index and the index of the prev apprearance

            if(map.containsKey(curr_sum - 0)){
                len = i -  map.get(curr_sum-0);
                maxlen = Math.max(maxlen, len);
            }
            
            // if difference is not seen then add the curr_sum and its index
            if(!map.containsKey(curr_sum)){
                map.put(curr_sum,i);
            }
            
        }
        
        return maxlen;
    }
}
