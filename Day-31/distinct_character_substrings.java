public class distinct_character_substrings {


    // similar to longest distinct char substring 
    public static long DistinctCharacterSubstring2(String s){
        //using sets counting the possible distinct char substrings
		HashSet<Character> set = new HashSet<>();
		int sp = 0;
		int ep = 0;
		long count = 0;
		while(ep<s.length()){

			if(set.contains(s.charAt(ep))) //repeated char found at ep
			{
				set.remove(s.charAt(sp)); // shrink the window as now the window cannot be consider as distinct char substring 
				sp++;
			}
			else{
				set.add(s.charAt(ep)); // expand the window by adding only the unique chars
				count+= ep-sp+1;
				ep++;
			}
		}

		return count;
			
    }

    public static long DistinctCharacterSubstring1(String s){
        //easy method
		HashMap<Character, Integer> map = new HashMap<>(); // char-> freq

		int sp = 0;
		int ep = 0;
		int count = 0;
		
		while(ep<s.length()){
			if(map.getOrDefault(s.charAt(ep),0)==0)
			{
				//freq = 0 so char is unique so calculate count of substrings ending with char at ep
				count+= ep-sp+1;
				map.put(s.charAt(ep),map.getOrDefault(s.charAt(ep),0)+1);
			    ep++; // expanding the window
			}
			else{  // char is repeated so shrink the window
					map.put(s.charAt(sp),map.get(s.charAt(sp))-1);
					sp++; // shrinking the window 
			}
		}

		return count;
		
		
    }

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