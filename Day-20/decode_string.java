class Solution {

    static int i =0;
    
    public String decodeString(String s)
    {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while(i<s.length())
        {

            char ch = s.charAt(i);

            if(Character.isDigit(ch))
            {
                num =10*num+(int)(ch-'0');
            }
            else if(Character.isLetter(ch))
            {
                sb.append(ch);
            }
            else if(ch=='['){
                i++;
                String temp = decodeString(s,i);// call function to solve remaining string and return the string
                String inner = "";
                // prepare a string repeating itself num times
                for(int j = 0 ; j<num ; j++)
                {
                    inner+=temp;
                }
                // add it to our ans
                sb.append(inner);
                num = 0;
            }
            else if(ch==']'){
                //return the answer back 
                return sb.toString();
            }

            i++;
        }

        return sb.toString();
    }

}

