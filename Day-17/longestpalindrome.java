public class longestpalindrome {

    //without DP

        public String longestPalindrome(String s) 
        {

            String ans = "";
            int maxlen = 0;

            for (int i = 0; i < s.length(); i++) 
            {
                int left = i;
                int right = i;
                //odd indexed string

                while (left >= 0 && right < s.length())
                {
                    if(s.charAt(left)==s.charAt(right)){
    
                        if (maxlen < right - left + 1) 
                        {
                            maxlen = right - left + 1;
                            ans = s.substring(left, right + 1);
                        }
                        //expanding the window
                        left--;
                        right++;
                    }
                    else{
                        break;
                    }
                }
    
    
                //even indexed string
                left = i;
                right = i + 1;
                while (left >= 0 && right < s.length()) 
                {
                    if(s.charAt(left)==s.charAt(right)){
    
                        if (maxlen < right - left + 1) 
                        {
                            maxlen = right - left + 1;
                            ans = s.substring(left, right + 1);
                        }
                        //expanding the window
                        left--;
                        right++;
                    }
                    else{
                        break;
                    }
                }
    
    
            }
    
            return ans;
    
        }
}
