import java.util.HashMap;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {

       // Note : While declaring map/ArrayList pass size parameter, it reduces space complexity

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length); //(element, index)

        int arr[] = new int[2];

        for(int i=0;i<nums.length;i++){

            // find the complimentary number in the map 

            if(map.containsKey(target-nums[i])){
                arr[0] = map.get(target -nums[i]);
                arr[1] = i;
                break;
            }

            // if not found add the number itself

            map.put(nums[i],i);
            
        }

        return arr;

    }

}
