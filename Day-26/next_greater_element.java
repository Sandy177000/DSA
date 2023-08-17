public class next_greater_element {
    
class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Integer> stack = new Stack<Integer>();
		stack.push(n-1);
		long[] ans = new long[n];
		ans[n-1] = -1;
		for(int i=n-2;i>=0;i--)
		{
			while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
				stack.pop();
			}
			if(stack.isEmpty()){
				ans[i] = -1;
			}else{
				ans[i] = arr[stack.peek()];
			}
			stack.push(i);
		}

		return ans;
    } 
}
}
