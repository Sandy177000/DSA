import java.util.ArrayList;

public class factorial_list {
    static ArrayList<Long> factorialNumbers(long N)
    {
        Long fact = 1L;
        Long x = 2L;
        ArrayList<Long> arr = new ArrayList<>();
        while (fact <= N)
        {
            arr.add(fact);
            fact = fact * x;
            x++;
        }
        
        return arr;
    }
// with recursion
    static ArrayList<Long> recursivefactorialNumbers(long N){
        Long fact = 1L;
        Long x = 2L;
        ArrayList<Long> arr = new ArrayList<>();
        facto(N,arr,x,fact);
        return arr;
        
    }
    static void facto(Long N, ArrayList<Long> arr, Long x,Long fact){
        if(fact>N){
            return;
        }
        
        arr.add(fact);
        fact = fact*x;
        facto(N,arr,x+1,fact);
        
    }

}
