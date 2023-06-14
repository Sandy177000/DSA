import java.util.*;

public class top_k_elements_in_array {
     public int[] topK(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i: nums)
        // Note: .getOrDefault( element, 0) returns value where element is the key else returns 0
            hm.put( i, hm.getOrDefault(i,0)+1);

        //  create a list from elements of the HashMap
        // Note: .entrySet() method returns the set of entries in hashmap
      
        List<Map.Entry<Integer, Integer>> al = new ArrayList<>(hm.entrySet());

        // sort the arraylist in descending order of values and if values are equal then descending order of keys
        // Note: We cannot directly use a.getValue() == b.getValue() instead use Objects.equals(obj1,obj2) method
        
        al.sort((a,b) -> Objects.equals(a.getValue(), b.getValue())? b.getKey()-a.getKey():b.getValue()-a.getValue());     
        
        int[] ans = new int[k];

        for(int i=0; i<k; i++){

            ans[i] = al.get(i).getKey();

        }

        return ans;
        
    }
}
