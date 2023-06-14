public class find_single_unique_element {

    public int singleNumber(int[] nums) {
        
        int number = 0;

       // bitwise XOR operator  ^
       // for r = a^b if a and b are same r = 0 else r = a + b

        for(int i=0;i<nums.length;i++){
            number = number ^ nums[i]; 
        }

        return number;
    }
    
}
