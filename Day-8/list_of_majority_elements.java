import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class list_of_majority_elements {
    

      public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        for(int i=0 ; i<n ; i++){
            if(map.get(nums[i])>n/3 && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }
    
}
