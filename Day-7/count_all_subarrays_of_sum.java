import java.util.HashMap;

public class count_all_subarrays_of_sum {
     public static int findAllSubarraysWithGivenSum(int arr[], int s) {
// ----------------Optimal prefix sum method------------------------------------
        
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();// (sum of subarray, frequency)

        int prefixsum = 0;// sum upto index current index

        for(int i=0;i<arr.length;i++){

            prefixsum+=arr[i];

            if(prefixsum == s){
                count++;
            }

            if(map.containsKey(prefixsum-s)){
                count+= map.get(prefixsum-s); // add the freq of subarray
            }

            if(map.containsKey(prefixsum)){
                map.put(prefixsum,map.get(prefixsum)+1);// increase the freq of subarray
            }
            else{
                map.put(prefixsum,1);
            }


        }
        return count; 
    }    

//--------------------------Brute force-----------------------------------------
    public static int findAllSubarraysWithGivenSum2(int arr[], int s) {
        // Write your code here.   
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int sum =0 ;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==s){
                    count++;
                }
            }
        }
        return count; 
    }
}
