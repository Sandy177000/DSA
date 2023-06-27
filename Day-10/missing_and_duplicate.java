public class missing_and_duplicate {
    int[] findTwoElement(int arr[], int n) {

        int freq[] = new int[n+1];
        
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]+=1;
        }
        
        int missing_number = 0;
        int duplicate_number = 0;
        
        for(int i=1;i<freq.length;i++){
            if(freq[i]==0){
                missing_number = i;
            }
            else if(freq[i]>=2){
                duplicate_number = i;
            }
        }
        
        int ans[] = new int[2];
        ans[1] = missing_number;
        ans[0] = duplicate_number;
        
        return ans;
    }
}
