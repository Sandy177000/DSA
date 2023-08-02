public class happy_number {
    static int nextHappy(int N){
        // code here
        N = N+1;
        
        while(true){
            if(isHappy(N)){
                return N;
            }
            N = N+1;
        }
    }
    
    static boolean isHappy(int n){
        
        int sum = 0;
        if(n==1){
            return true;
        }
        
        if(n==89)// special case if any number reaches 89 then it cannot ever become a happy number as 89 -> 8*8 + 9*9->145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
        {
            return false;
        }
        
        while(n>0){
            sum = sum + (n%10)*(n%10);
            n = n/10;
        }
        
        if(sum==1){
            return true;
        }
            
        return isHappy(sum);    
        
    }
}
