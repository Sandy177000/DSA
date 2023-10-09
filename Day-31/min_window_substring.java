public class min_window_substring {
    class Solution {

        // simpler approach
        public boolean isValid(HashMap<Character, Integer> ideal, HashMap<Character, Integer> curr)
        {
            for(Character ch: curr.keySet()){
                if(ideal.getOrDefault(ch,0)!=curr.get(ch)) return false;
            }
            return true;
        }
        
        public String minWindow(String s, String t) 
        {
            HashMap<Character, Integer> ideal = new HashMap<>();
            HashMap<Character, Integer> curr = new HashMap<>();
    
            for(int i = 0;i<s.length();i++)
            {
                char ch = t.charAt(i);
                ideal.put(ch, ideal.getOrDefault(ch,0)+1);
            }	
            
            int end = 0;
            int start = 0;
    
            int ansLen = s.length();
            String ans = "";
    
            while(end<s.length()){
    
                char currChar = s.charAt(end);
                curr.put(currChar, curr.getOrDefault(currChar,0)+1); // expanding the window
    
                while(isValid(ideal, curr)){ // checking if the freq of chars match with chars present in the target string
                    if(ansLen>end-start+1){
                        ansLen = end-start+1;
                        ans = s.substring(start, end+1);
                    }
    
                    curr.put(s.charAt(start), curr.get(s.charAt(start))-1);
                    start++; // shriking the window
                }
    
                end++;
            }
    
            return ans;
    
            
        }
    }
    

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
