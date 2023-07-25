/****Tricky question****/

public class minimum_possible_product  {
    class Solution 
{
    public int mod = 1000000007;
    public int minNonZeroProduct(int p) 
    {    
        long max_num = (long)Math.pow(2,p) -1;
        long x = max_num -1;
        long pow_x = x/2;

        // finding the power
        long y = helper(x,pow_x);
        //Concept: mininum product is always product of the max*(max-1)^((max-1)/2) 
        //according to the given conditions of swapping bits

        return (int)(y*(max_num%mod)%mod);

    }
  
    public long helper(long x, long n)
    {

        if(n==0){
            return 1;
        }
        if(n==1){
            return x%mod;
        }

        long ans = ((x%mod)*(x%mod))%mod;

        if(n%2==0){
            return helper(ans,n/2)%mod;
        }

        return ((x%mod)*helper(ans,n/2))%mod;
    }
}
}
