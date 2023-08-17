public class valid_parantheses {
    
class Solution{
    public static boolean checkValidString(int n, String s){
        //write code here
		Stack<Integer> open = new Stack<>(); // store the indices of (
		Stack<Integer> star = new Stack<>();  // store the indices of *

		for(int i=0;i<s.length();i++)
		{
			 char ch = s.charAt(i);
			 if(ch=='('){
				 open.push(i);
			 }
			 else if(ch == '*')
			 {
				 star.push(i);
			 }
			 else{ // balancing closing brackets 
				 if(!open.isEmpty())
				 {
					 open.pop(); 
				 }else{
					 if(!star.isEmpty())
					 {   
						 star.pop();
					 }else{
						 return false; // there is no one left to balance the ')'
					 }
				 }
			 }
			
		}

		while(!open.isEmpty()){  // check if there are extra open brackets balance it with *
			if(star.peek()<open.peek()){
				return false;  // * is present on the left side of the '(' hence it cannot be balanced
			}
			else{
				star.pop();  
				open.pop();
			}
		}
		if(open.isEmpty()){ // open stack is empty, meaning all the brackets are balanced
			return true;
		}
		return false;
    }
}
}
