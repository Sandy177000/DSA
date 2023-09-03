public class longest_subarray_of_0s_1s_2s {
    

class Solution{
    public static int longestSubarray(int[] arr){
        //String key approach
		HashMap<String,Integer> map = new HashMap<>();

		int ones = 0;
		int twos = 0;
		int zeros = 0;
		int maxLen = 0;
		map.put("0*0",-1); // imp step
		
		for(int i =0; i<arr.length;i++){

			if(arr[i]==0) zeros++;
			else if(arr[i]==1) ones++;
			else twos++;

			String key = (zeros - ones) + "*" + (zeros - twos); // imp step

			if(map.containsKey(key))
			{
				 int len = i - map.get(key);
				 maxLen = Math.max(len,maxLen);
			}

			if(!map.containsKey(key))
				map.put(key,i);
			
			
		}

		return maxLen;
		


		
    }
}

}
