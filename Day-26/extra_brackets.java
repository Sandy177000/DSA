public class extra_brackets {
    class Solution {
        public boolean ExtraBrackets(String exp) 
        {
            
            Stack<Character> st = new Stack<Character>();	
            for(int i=0;i<exp.length();i++)
            {
                if(exp.charAt(i)==')')
                {
                    if(st.peek()=='('){ // this means there is an extra bracket as '(' is at the top of stack without any poping
                      return true;
                    }
                    else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                        st.pop();
                    }
                }
                else
                {
                    st.push(exp.charAt(i));
                }
            }
            
            return false;
                
        }
    }
    
}
