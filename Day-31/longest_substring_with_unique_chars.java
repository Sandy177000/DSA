public class longest_substring_with_unique_chars {
    public int longestSubstring(String s) {

		HashSet<Character> set = new HashSet<>();
		int len = 0;
		int i = 0;
		int j = 0;
		
		while(j<s.length())
		{
			if(set.contains(s.charAt(j))){
				set.remove(s.charAt(i));
				i++;
			}
			else
			{
				set.add(s.charAt(j));
				len = Math.max(len,j-i+1);
				j++;
			}
		}

		return len;
		
    }
}
