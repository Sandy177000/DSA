class substring_concatenation_of_all_words{

    
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            
    
            List<Integer> ans = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for(String word: words){
                map.put(word,map.getOrDefault(word,0)+1);
            }
    
            int k = words.length*words[0].length(); // length of the valid string permutation
    
            for(int i = 0; i<=s.length()-k;i++){
                // pick a substring from s of length k (window)
                String str = s.substring(i,i+k);
                HashMap<String, Integer> curr = new HashMap<>();
    
                // create a map of words and check if the (window) substring contains all the words required
                for(int j = 0;j<=k-words[0].length();j+= words[0].length())
                {
                    String substr = str.substring(j,j+words[0].length());
                    curr.put(substr,curr.getOrDefault(substr,0)+1);
                }
    
                if(map.equals(curr)){
                    ans.add(i);
                }
    
            }
    
            return ans;
        }
    }
}