public class palindrome {
     //Optimal
    public boolean isPalindrome(String s) 
    {
        if(s.isEmpty()){
            return true;
        }
        // two pointers method
        int i = 0;
        int j = s.length()-1;

        while(i<=j){
            char start = s.charAt(i);
            char last = s.charAt(j);
            if(!Character.isLetterOrDigit(start)){
                i++;
            }
            
            else if(!Character.isLetterOrDigit(last)){
                j--;
            }

            else{

                if(Character.toLowerCase(start)!=Character.toLowerCase(last))
                {
                    return false;
                }
                i++;
                j--;
            }

        }

        return true;
   }
   // brute force but using recursion
   int isPalindromeRecursion(String S) 
    {
        if(S.length()<=1){
            return 1;
        }
        
        if(S.charAt(0) != S.charAt(S.length()-1)){
            return 0;
        }
        // passing reduced string
        return isPalindromeRecursion(S.substring(1,S.length()-1));
    }

}
