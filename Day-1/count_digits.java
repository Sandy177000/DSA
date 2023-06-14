public class count_digits {
     static int evenlyDivides(int N){
        int temp = N;
        int count =0;
        while(N>0){
            int d = N%10;
            if(d>0 && temp%d==0){
                count++;
            }
            N=N/10;
        }
        
        return count;
    }
}
