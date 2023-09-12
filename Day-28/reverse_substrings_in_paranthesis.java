public class reverse_substrings_in_paranthesis {
    class Solution {
        public String reverseParentheses(String s) 
        {   
    
            Stack<Character> st = new Stack<>();
    
            String temp = "";
            for(int i=0;i<s.length();i++){
    
                char ch = s.charAt(i);
                if(ch!=')'){
                    st.push(ch);
                }
                else{
                    temp = "";
                    // add all chars from stack to string
                    while(!st.isEmpty() && st.peek()!='(') temp+=st.pop();
                    st.pop();
    
                    // push back chars from string to stack
                    for(int j=0;j<temp.length();j++){
                        st.push(temp.charAt(j));
                    }
    
                }
            }
    
            StringBuilder ans = new StringBuilder();
            while(!st.isEmpty()) ans.append(st.pop());
    
            return ans.reverse().toString();
                    
        }
    }
}
