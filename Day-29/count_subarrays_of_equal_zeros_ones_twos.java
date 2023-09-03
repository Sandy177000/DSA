public class count_subarrays_of_equal_zeros_ones_twos {
    

class Solution {
    static int countEqualSubarray012(int arr[], int n)
    {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("0*0",1);
		int count = 0;
		int zero = 0;
		int one = 0;
		int two = 0;
		for(int i =0;i<n;i++)
		{
			if(arr[i]==0) zero++;
			else if(arr[i]==1) one++;
			else two++;

			// string key of differences in frequencies
			
			String key = (zero-one) + "*" + (zero-two); // important step

			if(map.containsKey(key)){
				count+= map.get(key);
			}

			map.put(key, map.getOrDefault(key,0)+1);

		}
		return count;
    }   

}


}
