public class subarray_sum_div_by_k {
    
    public static int subarrayDivisbleByK(int arr[], int n, int k){
        // Write code here 

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
