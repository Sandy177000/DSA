public class distinct_window {


    public static String DistinctWindow(String s){
            
        // store distinct chars in set
		HashSet<Character> set = new HashSet<>();

		for(int k=0;k<s.length();k++){
			set.add(s.charAt(k));
		}

		HashMap<Character, Integer> map = new HashMap<>();

		int i =-1;
		int j =-1;

		String ans = "";
		int anslen = Integer.MAX_VALUE;
		
		while(true)
		{
			boolean first = false;
			boolean second = false;
			// include the char in the substring/window 
			while(i<s.length()-1 && map.size()<set.size())
			{
				  first = true;
				  i++;
				  char ch  = s.charAt(i);
				  map.put(ch, map.getOrDefault(ch,0)+1);
			}

			// remove chars
			while(j<i && map.size()==set.size())
			{ 
				second = true;
				j++;
				// finding the substring
				int tempLen = i-j;
				if(tempLen<anslen)
				{
					anslen = i-j;
					ans = s.substring(j,i+1);
				}
				// removing char from map 
				char ch = s.charAt(j);
				if(map.get(ch)==1)
				{
					map.remove(ch);
				}
				else{
					map.put(ch, map.get(ch)-1);
				}
				
			}

			if(!first  && !second){
				 break;
			}

		
		}
		return ans;

	}
}
