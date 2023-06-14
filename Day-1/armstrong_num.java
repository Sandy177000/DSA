public class armstrong_num {
    static String armstrongNumber(int n){
        int sum = 0;
        int temp = n;
        
        while(n>0){
            sum += (int)Math.pow(n%10,3);
            n/=10;
        }
        if(sum==temp){
            return "Yes";
        }
        return "No";
    }
    
}
