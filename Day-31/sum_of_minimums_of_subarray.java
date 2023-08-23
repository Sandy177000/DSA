public class sum_of_minimums_of_subarray {

    // stack 
    public long minSubarraySum(int n, int a[]){

		Stack<Integer> st = new Stack<>();

		int[] nse = new int[n];
		int[] pse = new int[n];
 		for(int i=0;i<n;i++)
		{
			// tricky step a[st.peek()] > a[i]
			while(!st.isEmpty() && a[st.peek()]>a[i])
			{
				st.pop();
			}

			if(st.isEmpty()){
				pse[i] = -1;
			}else{
				pse[i] = st.peek();
			}

			st.push(i);
		}

		st.clear();
		
		for(int i=n-1;i>=0;i--)
		{

			// tricky step a[st.peek()] >= a[i]
			while(!st.isEmpty() && a[st.peek()]>=a[i])
			{
				st.pop();
			}

			if(st.isEmpty()){
				nse[i] = n;
			}else{
				nse[i] = st.peek();
			}

			st.push(i);
		}

		long sum = 0L;
		int mod = 1000_000_000+7;
		
		for(int i = 0;i<n;i++){
			sum = sum%mod + (1L*(i-pse[i])*(nse[i]-i)*a[i])%mod;
		}

		return sum%mod;
	}
}

