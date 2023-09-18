public class remove_min_subarray_divisible_by_p {
    public int minSubarray(int[] A,int n, int p) {

        // aim is to find the min length subarray such that after its removal the array becomes divisible by p

        int remainder = 0; // find the target remainder 
  
        for(int num:A)
        {
            remainder = (remainder+num)%p;
        }
  
        if(remainder==0) return 0;
        
        // map to store the remainders of the prefixsum
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int min = n; // max length possible 
        
        for(int i = 0;i<n;i++)
        {
            prefixSum = (prefixSum + A[i]) %p;  // remainder of the prefix sums
  
            // checking if target remainder exists in map previously
            if(map.containsKey((prefixSum-remainder+p)%p))
            {
                // store the min length 
                int len = map.get((prefixSum-remainder+p)%p);
                min = Math.min(min,i-len);
            }
  
            // store the prefixsum remainder occured at index i in map
            map.put(prefixSum,i);
             
        }
        return min==n?-1:min;
        
    }
}
