public class check_prime {
    public static void checkPrime(int n) {
    
	boolean notprime = false;
	for(int i =2 ; i<Math.sqrt(n) ; i++){
	   if(n%i==0){
		notprime= true;
	   }
	}
  
	if(!notprime){
		System.out.println(n+" is a prime number");
	}
	else{
		System.out.println(n+" is not a prime number");
	}
    
    }

    
    static boolean recursiveCheckPrime(int n){
    	return Prime(n,2);
    }

    static boolean Prime(int n, int i)
    {
        // Base cases
       if (n <= 2) 
           return (n == 2) ? true : false; 
	    
       if (n % i == 0) 
           return false; 
	    
       if (i * i > n)
            return true;
	    
        // Check for next divisor
        return Prime(n, i + 1);
    }
    
}
