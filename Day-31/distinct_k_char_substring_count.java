public class distinct_k_char_substring_count {
    class Solution{
        long substrCount (String s, int k)
        {
           
           return solve(s,k) - solve(s,k-1); // we find difference between at the most k and  k-1 distinct characters substrings 
        }
        
        // this function counts all the subtrings having at the most k distinct characters
        long solve(String s, int k){
            int ep = 0;
            int sp = 0;
            long ans = 0;
            int n = s.length();
            int distinct = 0 ;
            char[] map = new char[26];
            
            while(ep<n){
                
                char ch = s.charAt(ep);
                map[ch-'a']++;
                if(map[ch-'a']==1) distinct++;
                
                while(distinct>k){
                    char c = s.charAt(sp);
                    map[c-'a']--;
                    if(map[c-'a']==0) distinct--;
                    sp++;
                }
                
                ep++;
                ans+= ep -sp+1;
            }
            
            return ans;
        }
    }
}
