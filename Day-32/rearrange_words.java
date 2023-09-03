public class rearrange_words {
    class Solution {
        public String arrangeWords(String text) {
            
            // tree map is used to store the keys in sorted order 
            // keys are the length of the string
            // value is the list to store strings of the same length

            TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
    
            String[] arr = text.split(" ");
    
            for(int i = 0;i<arr.length;i++){
    
                int len = arr[i].length();
    
                if(map.containsKey(len)){
                    map.get(len).add(arr[i]);
                }else{
                     ArrayList<String> list = new ArrayList<>();
                     list.add(arr[i]);
                     map.put(len,list);
                }
            }
    
            StringBuilder sb = new StringBuilder();
    
            for(Map.Entry<Integer, ArrayList<String>> entry: map.entrySet())
            {
                for(String s :entry.getValue()){
                     sb.append(s.toLowerCase());
                     sb.append(" ");
                }
            }
    
            return sb.toString().substring(0,1).toUpperCase() + sb.toString().substring(1,sb.length()-1);
        }
    }
}
