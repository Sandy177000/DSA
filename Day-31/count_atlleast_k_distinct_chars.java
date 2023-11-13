public class count_atlleast_k_distinct_chars {
    class Solution {
        public int numberOfSubstrings(String s, int k) {
      
      
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int sp = 0, ep = 0;
     
        int ans = 0;
     
        while (ep < n) {
     
            char c = s.charAt(ep);
            map.put(c,map.getOrDefault(c,0)+1);
            ep++;
            
            // iterate till we have atleast 3 and count number of substrings
            while (map.size() >= k) {
     
                char pre = s.charAt(sp);
                map.put(pre,map.getOrDefault(pre,0)-1);
     
                if (map.get(pre)==0){
                    map.remove(pre);
                }
    
                ans += s.length() - ep + 1; // for at the least k distinct chars
                sp++;
            }
        }
     
                
                return ans;
        }
        
    }
}
