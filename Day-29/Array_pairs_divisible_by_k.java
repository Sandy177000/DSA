public class Array_pairs_divisible_by_k {
    
class Solution {
    public boolean arrayPairs(int[] arr, int k) {
		// hashmap of remainders and its frequency

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

		// storing remainders of the array elements and its freq
		for(int x:arr){
			map.put(x%k,map.getOrDefault(x%k,0)+1);
		}

		for(int i=0;i<arr.length;i++)
		{    // the remainder of number is zero then its freq should be even to form pairs
			if(arr[i]%k==0)
			{
				if(map.get(arr[i]%k)%2!=0)
				{
					 	return false;
				}
			}
			// if the remainder half of k then its freq should be even
			else if((arr[i]%k)*2 == k)
			{
				if(map.get(arr[i]%k)%2!=0)
				{
					 	return false;
				}
			}
		    // check whether k - remainder and remainder freq are same so that pairs can be formed
			else{
				if(map.get(arr[i]%k)!=map.get(k-(arr[i]%k)))
				{
					 	return false;
					
				}
			}
		}

		return true;
    }
}
}
