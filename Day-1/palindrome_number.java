public class palindrome_number {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int temp = x;
        if(x<0){
            return false;
        }
        while(x>0){
            int d = x%10;
            rev = rev*10 + d;
            x=x/10;
        }
        if(rev==temp){
            return true;
        }
        return false;
    }
}
