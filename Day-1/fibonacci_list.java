public class fibonacci_list {
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        long a = 1L;
        long b = 1L;
        long c = 0L;
        long arr[] = new long[n];
        
        if(n<=2){
            for(int i=0;i<n;i++){
                arr[i] = 1;
            }
        }
        else{
            arr[0] =1;
            arr[1] =1;
            
            for(int i=2;i<n;i++){
                c = a+b;
                a = b;
                b = c;
                arr[i] = c;
            
            }
        }
            return arr;
        
    }    
}
