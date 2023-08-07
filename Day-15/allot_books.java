public class allot_books {
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //edge case
        if(N<M){
            return -1;
        }

        int low = Integer.MIN_VALUE;// least pages student must be able to read(max in array)
        
        int high = 0;// total pages in array-> maximum possible capacity of student
        
        for(int i=0;i<N;i++){
            low = Math.max(low, A[i]);
            high += A[i];
        }
        
        while(low<=high){
            int mid = (low+high)/2;// maximum pages one student can read
            
            if(possible(A, mid, M)){// check if we can assign M students each with mid(capacity of reading)
                
                low = mid+1;
            }
            else{
                
                high = mid-1;
            }
        }
        
        return low;
        
    }
    
    public static boolean possible(int A[], int max_pages, int students)
    {
        int pages = 0;
        
        int num_of_students = 1;
        
        for(int i=0;i<A.length;i++)
        {
            if(pages+A[i]<=max_pages)
            {
                pages+=A[i];
            }
            
            else
            {
                pages = A[i];
                num_of_students++;
            }
        }
        if(num_of_students>students){
            return true;
        }
        return false;
        
        
    }    
}
