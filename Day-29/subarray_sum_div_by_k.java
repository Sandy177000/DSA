public class subarray_sum_div_by_k {
    
    public static int subarrayDivisbleByK(int arr[], int n, int k){
        // Write code here 

		//  concept :  if we get same remainder again it means that there exists a subarray divisible by k

		// arr [1,2,4,8,0] k = 6
		// rem [1,3,1,3,3]
		      // s1 and s2 prefix sums
		      //s1 = 1 (0,0)
			  //s2 = 7 (0,2)
			  // s1 = 6*m + 1  m = 0
			  // s2 = 6*n + 1  n = 1
			  // s2 - s1 = 6(n-m) ----> this implies the subarray between s2 and s1 [2,4] is divisible by 6

		// ans [0,0, 0+1, 0+1+1, 0+1+1+2] = 4 

		HashMap<Integer,Integer> map = new HashMap<>();

		int sum = 0;
        int rem = 0;
		int ans = 0;
		
		map.put(0,1);
		for(int i=0;i<n;i++){
			sum+=arr[i];
			rem = sum%k;

			if(rem<0){
				rem = rem + k;
			}

			ans+=map.getOrDefault(rem,0);
			map.put(rem,map.getOrDefault(rem,0)+1);
		}


		return ans;
		
		
    }
}
