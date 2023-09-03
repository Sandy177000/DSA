public class count_all_subarrays_equal_ones_zeros {

class Solution 
{

    //1.String key approach : similar approach used in count equal zeros, ones and twos subarrays

    static int countEqualSubarray01_(int arr[], int n)
    {
		HashMap<String, Integer> map = new HashMap<>();

		int count = 0;
		int ones  = 0;
		int zeros =  0;

		map.put("0*0",1);
		for(int i=0;i<arr.length;i++)
		{			
			if(arr[i]==0) 
				zeros++;
			else
				ones++;

			String key = (zeros - ones )+ "*" + (ones - zeros); //imp step
			if(map.containsKey(key))
			{
				count+= map.get(key);
			}
			map.put(key,map.getOrDefault(key,0)+1);
			
		}

		return count ;
    }  


    // 2. prefix sum approach
    static int countEqualSubarray01(int arr[], int n)
    {
		HashMap<Integer, Integer> map = new HashMap<>();

		int count = 0;
		int sum = 0;
		for(int i=0;i<arr.length;i++)
		{

			// considering zero as -1 because if the subarray contains
			// equal number of ones and zeros then sum of the subarray is always zero
			// and we can use prefixsum technique to find out subarrays of sum zero
			
			if(arr[i]==0) 
				sum = sum-1;
			else
				sum = sum+1;

			// sum becomes zero means we have found an subarray
			if(sum == 0){
				count++;
			}

			// check in map if we got sum as zero previously
			if(map.containsKey(sum-0)){
				count+= map.get(sum-0);
			}

			// store the prefix sum in map and increase its freq 
			map.put(sum,map.getOrDefault(sum,0)+1);
			
		}

		return count ;
    }   
}

}
