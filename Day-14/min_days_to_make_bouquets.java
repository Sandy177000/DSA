public class min_days_to_make_bouquets {
    public int minDays(int[] bloomDay, int m, int k) {

        //edge case
        long mm = (long) m;
        long kk = (long) k;       
        long val =   mm*kk;

        if(bloomDay.length<val){
             return -1;
        }
         
        // find the range
         int low = Integer.MAX_VALUE;
         int high = Integer.MIN_VALUE;

        for(int i=0;i<bloomDay.length;i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }

        // binary search for all the days in the range
        while(low<=high){

             int mid = (low+high)/2;

             if(possible(bloomDay, mid, m, k)){  
                high = mid-1;// move to left part
             }
             else{
                low = mid+1;// move to right part
             }
        }
        return low; // minimum number of days to form k set of m bouquets 
    }

    // check if k sets of m bouquets are formed in bloomday 

    public boolean possible(int arr[], int bloomday, int m, int k)
    {
        int count = 0;
        int number_of_bouquets = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=bloomday){
                count++;
            }
            else{
                number_of_bouquets+= (count/k); 
                count = 0;// reset the count
            }
        }
        
        number_of_bouquets+= (count/k); // corner case for the elements left in array

        if(number_of_bouquets>=m){
            return true;
        }

        return false;
    }
}    

