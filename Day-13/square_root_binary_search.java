public class square_root_binary_search {
    
     long floorSqrt(long x)
	 {
		long low = 1;
		long high = x;
		long sqroot = 1;
		
		while(low<=high){
		    
		    long mid = (low+high)/2;
		    
		    if(mid*mid>x){
		        high = mid-1;
		    }
		    //similar to finding the floor value using binary search
		    else if(mid*mid<=x){
		        low = mid +1;
		        
		        sqroot = mid;
		    }
		}
		
		return sqroot;
	 }
         
}
