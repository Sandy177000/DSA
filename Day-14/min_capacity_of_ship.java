public class min_capacity_of_ship {
    public int shipWithinDays(int[] weights, int days) {
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<weights.length;i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;

            if(possible(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }

        return ans;
        
    }

    public boolean possible(int arr[], int days, int min_capacity){

        int count_days = 1;
        int capacity = 0;

        for(int i=0;i<arr.length;i++){
            
            if(capacity+arr[i]<=min_capacity){
                capacity+=arr[i];
            }
            else{
                count_days++;
                capacity = arr[i];
            }
        }

        if(count_days<=days){
            return true;
        }

        return false;

    }
}
