class Solution
{
    //Function to calculate the span of stocks price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        
        int ans[] = new int[price.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        ans[0] = 1;
        int idx = 1;
        
        for(int i=1;i<price.length;i++)
        {
            // remove all the indices of the elements less than current element from th stack
            while(!stack.isEmpty() && price[i]>=price[stack.peek()]){
                stack.pop();
            }
            
            // if the stack becomes empty then there is no element on the left hand side of the current element
            // hence the span size would be i+1
            if(stack.isEmpty()){
                ans[idx] = i+1;
            }else{
            //  difference in the current index and the latest element which is greater than the current element
                ans[idx] = i-stack.peek();
            }
            idx++;
            stack.push(i);// storing the index of the current element in the stack
        }
        
        
        return ans;
        
        
    }
    
}