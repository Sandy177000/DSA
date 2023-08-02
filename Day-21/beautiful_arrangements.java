/**
 * beautiful_arrangements
 */
public class beautiful_arrangements {

    // standard permutation problem
    class Solution {

        public int countArrangement(int n)
        {   
            return solve(n,1,new boolean[n+1]);
            
        }
    
        public int solve(int n,int index, boolean[] visited) // index is used to track position of the ith number
        {
            if(index>n)
            {    
                return 1;
            }
    
            int count = 0;
            for(int i=1;i<=n;i++)
            {        
                if(!visited[i] && ((i%index)==0 || (index%i)==0)) // add a check if it is valid or not 
                {
                    visited[i] = true;
                    count+=solve(n, index+1,visited);
                    visited[i] = false;
                }
            }
    
            return count;
        }
    }
}