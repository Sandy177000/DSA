public class celebrity_problem {
    
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
       Stack<Integer> stack = new Stack<>();

		for(int i=0;i<M.length;i++){
			stack.push(i);
		}

		while(stack.size()>=2)
		{   
			// picking top 2 persons
			int p1 = stack.pop();
			int p2 = stack.pop();
			if(M[p1][p2]==1){ // p1 knows p2
				stack.push(p2); // p2 might be celeb p1 is not
			}
			else{
				stack.push(p1); //p1 might be celeb p2 is not
			}
		}

		int celeb = stack.pop();
		
		// check if the celeb is actually a celeb
		for(int i=0;i<M.length;i++)
		{
			if(M[celeb][i]==1 && celeb!=i){ // celeb knows i thus can't be a celeb
				return -1;
			}
		}

		return celeb;
    }

}
}
