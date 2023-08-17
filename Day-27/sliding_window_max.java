/**
 * sliding_window_max
 */
public class sliding_window_max {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) 
        {
    
             int n = nums.length;
             Deque<Integer> dq = new ArrayDeque<>();
    
             int[] ans = new int[n-k+1];
             int index=0;
    
             for(int i=0;i<nums.length;i++)
             {
                
                if(!dq.isEmpty() && i-k==dq.peekFirst())
                {
                    dq.pollFirst(); // removing the element from the left end of queue
                }
    
                while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                    // while the element at curr index is greater than the elements in the dq remove them from right end
                    dq.pollLast();
                }
    
                // adding the element to the right of the queue
                dq.offerLast(i);
    
                
                if(i>=k-1)
                {
                    // storing the max which logically is at the left of the deq
                    ans[index] = nums[dq.peekFirst()];
                    index++;
                }
    
             }
    
             return ans;
    
        }
    }
}