public class prev_greater_element {
    public static long[] prevGreater(long[] arr, int n)
    { 
		Stack<Integer> st = new Stack<Integer>();
		long[] ans = new long[n];
		ans[0] = -1;
		st.push(0);
		for(int i=1;i<n;i++)
		{
             
		    while(!st.isEmpty() && arr[i]>arr[st.peek()])
            { 
				st.pop();
			}

			if(st.isEmpty()){
				ans[i] = -1;
			}else{
				ans[i] = arr[st.peek()];
			}

			st.push(i);
		}
		return ans;	
    }
}
