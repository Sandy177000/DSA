class Solution
{
    public static long maximumArea(long hist[], long n)
	{
		
		Stack<Integer> stack = new Stack<>(); // store the indices
        int N = hist.length;
		long prev[] = new long[N];
		long next[] = new long[N];

		// find the next small element to the left of the curr element
		for(int i=0;i<N;i++){
			while(!stack.isEmpty() && hist[stack.peek()]>=hist[i]){
				stack.pop();
			}

			if(stack.isEmpty())
			{
				prev[i] = -1;	
			}
			else{
				prev[i] = stack.peek();
			}

			stack.push(i);
		}

        // Empty the stack 
		while(!stack.isEmpty()) {stack.pop();}

		
		// find the next small element to the right of the curr element
		for(int i=N-1;i>=0;i--)
		{
			while(!stack.isEmpty() &&  hist[stack.peek()]>= hist[i]){
				stack.pop();
			}
			if(stack.isEmpty())
			{
				next[i] = N; // this means there is no upper bound in the array
			}
			else{
				next[i] = stack.peek(); // there exists a element less than curr element acts as a boundary
			}

			stack.push(i);
		}

		long area = 0;
		for(int i=0;i<N;i++){
			area = Math.max(area, (next[i]-prev[i]-1)*hist[i]); // calculate area at each bar and store the max
		}
		return area;
    }
}





