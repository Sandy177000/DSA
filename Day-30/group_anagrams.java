public class group_anagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    
            for(int i=0;i<strs.length;i++){
                char arr [] = strs[i].toCharArray();
                Arrays.sort(arr);
                String key = String.valueOf(arr);
    
                // add key value to the list if not present
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<String>());
                }
    
                //get the value having key i.e the list and add the string 
                map.get(key).add(strs[i]);;
            }
    
            return new ArrayList<>(map.values());
        }
    }
}
