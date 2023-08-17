public class balanced_brackets {

class Solution{
    public void balancedBrackets(String s, int n) 
	{
		boolean flag = true;
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<s.length();i++)
        {
			if(s.charAt(i)=='('||s.charAt(i)=='{' || s.charAt(i)=='[')
            {
				st.push(s.charAt(i));
			}
            
            else{
				if(!st.isEmpty())
				{
                    char ch = st.peek();
				    if(ch=='('&& s.charAt(i)==')'||ch=='{'&& s.charAt(i)=='}'||ch=='['&& s.charAt(i)==']')
                    {
				    	st.pop();
				    }
                }
				else
                {
					flag = false;
					break;
				}
			}
		}

		if(flag)
		{
			if(st.isEmpty())
				System.out.println("YES");
			else
			{
			System.out.println("NO");}
		}
		else{
			
			System.out.println("NO");
		}

		
    }
}

}