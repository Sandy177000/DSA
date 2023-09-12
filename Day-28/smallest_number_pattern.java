public class smallest_number_pattern {
    public String smallestNumber(String pattern){
        
		Stack<Integer> st=new Stack<>();
        String res="";
        for(int i=0;i<=pattern.length();i++)
		{
            st.push(i+1);
            if(i==pattern.length() || pattern.charAt(i)=='i')
            {
                while(st.size()>0){
                    res+=String.valueOf(st.pop());
                }
            }
        }
        return res;
		
    }
}
