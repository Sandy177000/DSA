public class min_window_substring {

    // similar to distinct window
    class Solution {
        public String minWindow(String s, String t) 
        {
            // Storing the chars and freq in the reference map
            HashMap<Character, Integer> ref = new HashMap<>();
    
            for(int k=0;k<t.length();k++)
            {
                char ch = t.charAt(k);
                ref.put(ch, ref.getOrDefault(ch,0)+1);
            }
    
            HashMap<Character, Integer> map  = new HashMap<>();
    
            // pointers for the window
            int i = -1;
            int j = -1;
    
            String ans = "";
            int ansLen = 0;
            int target = t.length();
    
            while(true){
    
                boolean first = false;
                boolean second = false;
                // acquire chars if the ans
                while(j<s.length()-1 && ansLen<target)
                {
                    first = true;
                    j++;
                    char ch = s.charAt(j);
                    map.put(ch, map.getOrDefault(ch,0)+1);
    
                    if(map.getOrDefault(ch,0)<=ref.getOrDefault(ch,0)){
                        ansLen++;
                    }
                }
    
                // remove chars
                while(i<j && ansLen==target)
                {
                    // finding the substring 
                    second = true;
                    String temp = s.substring(i+1,j+1);
    
                    if(ans.length()==0 || temp.length()<ans.length()){
                        ans = temp;
                    }
    
                    i++;
                    char ch = s.charAt(i);
                    if(map.get(ch)==1)
                    {
                        map.remove(ch);
                    }
                    else{
                        map.put(ch,map.get(ch)-1);
                    }
    
                    // 
                    if(map.getOrDefault(ch,0)<ref.getOrDefault(ch,0)){
                        ansLen--;
                    }
                }
    
                if(first == false && second == false)
                {
                    break;
                }
            }
    
            return ans;
        }
    }
}
