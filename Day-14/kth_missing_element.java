public class kth_missing_element {
    public int findKthPositive(int[] arr, int k) {
        
        int i = 1;
        int idx = 0;
        int missing_element = 0;

        while(idx<arr.length && k>0){
        
                if(arr[idx]==i){
                    idx++;   
                }
                else{    
                    missing_element = i;
                    k--;
                }
                i++;
            
        }
        while(k>0){
            missing_element= i;
            i++;
            k--;
        }
        
        return missing_element;
    }
}

