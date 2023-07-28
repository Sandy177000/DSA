public class find_the_winner {
    class Solution {
        public int findTheWinner(int n, int k) {
            
           return 1 + helper(n,k);
        }
        public int helper(int n, int k){
            if(n==0){
                return 1;
            }
            else{
                int pos = (helper(n-1,k) + k)%n ;
                return pos;
            }
        }
    
    }
}
