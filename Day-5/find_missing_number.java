public class find_missing_number {

    public static int missingNumber(int A[], int N)
    {
        
         int actualSum = 0;
         for(int x:A){
             actualSum+=x;
         }
         
         int sum = 0;
         
         for(int i=1;i<=N;i++){
             sum += i;
         }
         
         return sum - actualSum;
    }
    
}
