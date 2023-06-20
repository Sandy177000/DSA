public class trapping_rain_water {
    
     public int trap(int[] height) {
        int n = height.length;
        // array of maximum value on the left side of the ith element
        int leftwall[] = new int[n];
        int maxLeft = height[0];
        for(int i=1;i<n-1;i++){
            if(maxLeft<height[i]){
                maxLeft = height[i];
            }
            leftwall[i] = maxLeft;
        }
        // array of maximum value on the right side of the ith element
        int rightWall[] = new int[n];
        int maxRight = height[n-1];
        for(int i = n-2;i>=1;i--){
            if(maxRight<height[i]){
                maxRight = height[i];
            }
            rightWall[i] = maxRight;
        }
        // difference between max possible height(of the maximum values of the ith element)and
        // height at ith index 
        // sum of all the differences
        int total_water = 0;
        for(int i=1;i<=n-2;i++){
            int maximum_possible_height = Math.min(leftwall[i],rightWall[i]);
            int water_at_ith_place = maximum_possible_height - height[i];
            total_water+= water_at_ith_place;
        }

        return total_water;
    }
}
