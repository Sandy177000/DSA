public class min_stack {
    
class Solution
{
	int minEle = Integer.MAX_VALUE;
	Stack<Integer> s;
    
	Solution()
	{
		s = new Stack<Integer>();
	}

	void push(int x){
		if(s.isEmpty())
		{
			minEle = x;
			s.push(x);
		}
		else if(x>=minEle)
		{
			
			s.push(x);
		}
		else
		{
			
			s.push(2*x -minEle);
			minEle = x;
		}
		
    }
	
	int pop()
	{
		int x = 0;
		if(!s.isEmpty())
		{
		    x = s.peek();
			if(x>=minEle)
			{
			    return s.pop();
			}
			else
			{   
				int y  = minEle;
				minEle = 2*minEle - s.pop();
				return y;
			}
		}
		else
		{
			return -1;
		}
		
	}

    int getMin(){
		if(s.isEmpty()) return -1;
		
		return minEle;
	}	
}

}
