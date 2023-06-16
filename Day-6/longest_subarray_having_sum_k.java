import java.util.HashMap;

public class longest_subarray_having_sum_k {

    //Optimal solution which works for negative, positive and zero element value
    public static int lenOfLongSubarr (int A[], int N, int K) {
    
        HashMap<Integer,Integer> prefixSum = new HashMap<Integer,Integer>();// prefixsum, index+1
        
        int sum = 0;
        int maxlen = 0;
        
        for(int i=0;i<N;i++){
            sum+=A[i];
            
            if(sum==K){
                maxlen = Math.max(maxlen,i+1);
            }
            
            // if map already has prefix sum i.e sum before curr index
            // then store the diff between indices in map which would 
            // be length of the subarray
            
            if(prefixSum.containsKey(sum-K)){
                
                int len = i-prefixSum.get(sum-K);
                
                maxlen = Math.max(len,maxlen);
            }
            
            //Add the sum and the index upto which sum is calculated if 
            //it is not present
            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum,i);
            }
        }
        
        return maxlen;
    }

    //brute force
    public static int longest_sub_with_sum_k(int A[], int N, int K)
    {   
        int size = 0;
        for(int i=0;i<N;i++){
            int sum = 0;
                
            for(int j=i;j<N;j++){
                sum+=A[j];
                if(sum==K){
                      if(size<j-i+1){
                        size = j-i+1;
                      }
                    }
            }
        }
        return size;

    }
}
