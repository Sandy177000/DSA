public class print_all_divisors {
    public static void printDivisors(int n)
    {
		for(int i = 1; i <= (int)Math.sqrt(n); i++){
			if(n % i == 0){
				System.out.print(i + " ");
				if(i != n/i){ // compliment factor
                     System.out.print(n/i + " ");
                }
			}
        }
			
    }

}
