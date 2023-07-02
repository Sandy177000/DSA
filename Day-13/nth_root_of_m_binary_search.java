public class nth_root_of_m_binary_search {
    
    public int NthRoot(int n, int m)
    {
        
		int low = 1;
		int high = m;
		
		while(low<=high){
		    
		    int mid = (low+high)/2;
		    
		    if(Math.pow(mid,n)>m){
		        high = mid-1;
		    }
		    else if(Math.pow(mid,n)<m){
		        low = mid +1;
		        
		    }
		    else{
		        return mid;
		    }
		}
		
		return -1;
	}
       
}
