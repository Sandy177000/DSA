// TRICKY QUESTION

public class kth_bit {

    class Solution {
        public int kthGrammar(int n, int k) {
    
            return  helper(n, k);
            
        }
        public int helper(int n,int k){
            //base case
            if(n==1 && k==1){
                return 0;
            }
    
            int mid = (int) Math.pow(2, n-1)/2;

            // if the index k which we want is less than the mid point of the nth String
            if(k<=mid){
                return helper(n-1,k); // call for n-1 number
            }
            else{
                int result = helper(n-1, k-mid); // call for n-1 number but for k-mid index
                if(result ==0){
                    return 1; // on observation if we get 0 answer is 1 and vice versa
                }
                else{
                    return 0;
                }
            }
        }
    }
}