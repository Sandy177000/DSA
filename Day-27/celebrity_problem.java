public class celebrity_problem {
    



class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	
    	while(st.size()>1){
    	    int p1 = st.pop();
    	    int p2 = st.pop();
    	    // p1 does not know p2  
    	    if(M[p1][p2]==0){
    	        st.push(p1); // p1 may be celeb
    	    }
    	    else{
    	        st.push(p2); // p2 may be celeb
    	    }
    	}
    	
    	int celeb = st.pop();
    	
    	int celeb_does_not_know  = 0 ; // n people (including himself)
     	int people_who_know_celeb = 0; // n-1 people 
    	
    	for(int i = 0;i<n;i++)
    	{
    	    // celeb does not know anyone
    	    if(M[celeb][i]==0){
    	        
    	        celeb_does_not_know++;
    	        
    	    }
    	    if(M[i][celeb]==1){
    	    // all know celeb
    	        people_who_know_celeb++;
    	    }
    	}
    	
    	
    	if(people_who_know_celeb==n-1 && celeb_does_not_know == n){
    	    return celeb;
    	}
    	else{
    	    return -1;
    	}
    	
    	
    }
}
}
