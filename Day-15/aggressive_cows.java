import java.util.*;

public class aggressive_cows {

    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);// sorting the array
        
        int low = 0;// minimum distance between stalls
        
        int high = stalls[n-1] - stalls[0]; // maximum distance between stalls
        
        // binary search for the minimum distance between stalls 
        // with the help of which all the k cows can be placed

        while(low<=high){
            int mid = (low+high)/2;
            
            
            if(possible(stalls, mid, k)){
                
                low = mid+1;
            }
            else{
                
                high = mid-1;
            }
        }
        
        return high;
    }
    
    public static boolean possible(int stalls[], int min_dist, int cows)
    {
        int count_cows = 1;
        int prev = stalls[0];
        
        // finding out all those stalls which has a min distance
        
        for(int i=1;i<stalls.length;i++)
        {
            if(stalls[i]-prev>=min_dist)
            {
                count_cows++;
                prev = stalls[i];// replacing the previous stall with current
            }
        }
        
        if(count_cows>=cows){
            return true;
        }
        
        return false;
        
    }
}