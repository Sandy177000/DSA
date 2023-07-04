public class koko_eats_bananas 
{
        public int minEatingSpeed(int[] piles, int h) {
        
        // find the maximum eating speed
        int max = 0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }

        int low = 1; // minimum possible speed
        int high = max; // max possible speed
        int ans = Integer.MAX_VALUE;

        // binary search in between low and high which are the possible speeds of eating

        while(low<=high){
            int mid = (low+high)/2;

            if(possible(piles, mid,h)){// function to check eating speed (mid) is possible or not
                ans = Math.min(mid,ans);
                high = mid - 1;// shift to left
            }
            else{
                low = mid + 1; // shift to right
            }
        }

        return ans;
    }

    public boolean possible(int arr[], int rate, int deadline)
    {   
        int time_taken = 0;

        //calculating total time taken to eat all piles with speed 'rate'
        
        for(int i=0;i<arr.length;i++)
        {
            time_taken+= Math.ceil((double)arr[i]/rate); 
        }

        if(time_taken <= deadline){// time taken should be less or equal to the time limit
            return true;
        }
        return false;

    }
}
