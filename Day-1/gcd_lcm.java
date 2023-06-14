public class gcd_lcm {
    // Optimal solution TC = O(log(min(A,B))
    // Brute force TC = O(min(A,B)
    static Long[] lcmAndGcd(Long A , Long B) {
        Long gcd = 1L;
        Long AA = A;
        Long BB = B;
        
        // Euclidean principle of hcf or gcd
        // gcd (a,b) = gcd(a%b,b) 
        
        while(A>0 && B>0){
            if(A>B){
                A = A%B;
            }
            else{
                B = B%A;
            }
        }
  
        if(A==0){
            gcd = B;
        }
        else{
            gcd = A;
        }
      
        // gcd*lcm = A*B 
      
        Long lcm = (AA*BB)/ gcd;
        Long arr[] = new Long[2];
        arr[0] = lcm;
        arr[1] = gcd;
        
        return arr;
    }
}
