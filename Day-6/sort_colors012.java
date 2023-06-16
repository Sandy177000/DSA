public class sort_colors012 {
    
    public void sortColors(int[] nums) {
        int z = 0;
        int o = 0;

        int n = nums.length;
        for(int i=0;i<n;i++){
            // count zeros and ones
            if(nums[i]==0){
                z++;
            }
            else if(nums[i]==1){
                o++;
            }
        }
    
        // replace elements with zero
        for(int i=0;i<z;i++){
            nums[i] = 0;
        }

        // then with one
        for(int i=z;i<z+o;i++){
            nums[i] = 1;
        }

        // remaining with two
        for(int i=z+o;i<n;i++){
            nums[i] = 2;
        }
    }
}
