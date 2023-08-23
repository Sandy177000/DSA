public class pattern_132 {
    class Solution {
        public boolean find132pattern(int[] nums) {
            
            int thirdNumber = Integer.MIN_VALUE;
    
            Stack<Integer> st = new Stack<>();
    
            for(int i=nums.length-1;i>=0;i--)
            {
                if(nums[i]<thirdNumber) return true;
    
                while(!st.isEmpty() && st.peek()<nums[i])
                {
                        //finding the next greater element
                        thirdNumber = st.pop();// storing the prev greater
                         // removing elements less than the curr element
                }
    
                st.push(nums[i]); // storing second number in stack which is always maximum
            }
    
    
            return false;
    
        }
    }
}
