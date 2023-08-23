public class distinct_character_substrings {

    public static long DistinctCharacterSubstring(String s){

        
    // hashMaps to store the freq of the char in the string
		HashMap<Character,Long> map = new HashMap<>();
		long count = 0;
		int i = -1;
		int j = -1;
		int len = s.length();

		while(true)
		{
			
		boolean firstLoop = false;
		boolean secondLoop = false;
		
			// including the char in substring
			while(j<len-1)
			{
				firstLoop = true;
				j++;
				char ch = s.charAt(j);

                // increase freq of  char
				map.put(ch,map.getOrDefault(ch,0L)+1L);
				// Invalid substring as char is repeated
				if(map.get(ch)==2L){
					break;
				}
				else{
					// counting all the distinct char-substrings
					count +=j-i;
				}
			}

			// shifting substring window to right=>excluding chars
			while(i<j)
			{
				secondLoop = true;
				i++;
				char ch = s.charAt(i);
				// decrease the freq of the char in map
				map.put(ch,map.get(ch)-1L);

				// valid substring as freq of char is 1
				if(map.get(ch)==1L)
				{
					count+=j-i; 
					break;
				}
			}

			if(firstLoop == false && secondLoop == false){
				break;
			}
		}

		return count;
    }

}