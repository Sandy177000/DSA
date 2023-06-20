import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;



public class three_sum {
    
    // Type-1 find the max sum of 3 numbers closest to X

    // 3 pointer method
    static int closest3Sum(int A[], int N, int X)
    {
        Arrays.sort(A);
        int max_sum = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int i=0;i<N;i++)
        {
            int j = i+1;
            int k = N-1;
            while(j<k){
                int sum = A[i] + A[j] + A[k];
                
                if(Math.abs(X-sum)<diff) // minimize the difference
                {
                    max_sum = sum;
                    diff = Math.abs(X-sum);
                }
                
                if(sum<X){
                    j++;
                }
                
                else{
                    k--;
                }
            }
        }
        
        return max_sum;
    }

    // Type 2: Sum of three numbers equal to X
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        HashSet<List<Integer>> SetofList = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        // 3 pointer approach in sprted array
        
        for(int i=0;i<n;i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum==0){
                    SetofList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;

                }
                else if(sum>0){
                    k--;
                }
                else{
                    j++;

                }
            }
        } 
        list.addAll(SetofList);
        return list;

    }
}
