public class sum_of_cube_series {
     long sumOfSeries(long N) 
    {
        if(N==1L){
            return 1L;
        }  
        return (long) Math.pow(N,3) + sumOfSeries(N-1);
    }
    
}