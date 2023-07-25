public class handshakes {

    static int count(int N) 
    //dp approach
    { 
        
        int[] dp = new int[N+1];
        
        dp[0] = 1;
        
        for(int n=2;n<=N;n+=2)
        {
            for(int i = 0 ; i<=n-2;i+=2)
            {
                dp[n] += dp[i]*dp[n-2-i];
            }
        }
        
        return dp[N];
    }

    // recursive approach gives tle
    class Solution{
        static int count(int N) 
        { 
           return helper(N,0);
        }
        
        static int helper(int N,int sum){
            
            if(N==0){
                return 1;
            }
            
            if(N==2){
                return 1;    
            }
            
            int sums = 0;
            for(int i=0;i<N;i++)
            {
                sums+=helper(i,sum)*helper(N-i-2,sum);
            }
            
            return sums;
            
        }
    };
}
