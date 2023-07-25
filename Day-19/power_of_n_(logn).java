
public class power_of_n_logn {
    class Solution {
        public double myPow(double x, int n) {
            
            if(n==0){
                return 1;
            }
    
            double ans = solve(x,n);
    
            if(n>0){
                return ans;
            }
            else{
                return 1/ans;
            }
        
        }
    
        public static double solve(double x, int n){
    
            if(n==0){
                return 1D;
            }
            
            double ans = 0;
            ans = solve(x,n/2);
            ans = ans*ans;
    
            if(n%2!=0){
                return x*ans;
            }
            else{
                return ans;
            }
    
        }
    
    }
    
}