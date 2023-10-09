public class distinct_window {


	// easy method similar to minimum window substring

	public static boolean isValid(HashMap<Character, Integer> curr, HashMap<Character, Integer> ideal){

		for(Character ch: ideal.keySet()){
			if(!curr.containsKey(ch)) return false; // char is not present in the curr
				
			 else if(curr.getOrDefault(ch,0)<ideal.get(ch)) return false;
		}
		return true;
	}

    public static String DistinctWindow2(String s){

		HashMap<Character, Integer> curr = new HashMap<>();
		HashMap<Character, Integer> ideal = new HashMap<>();

		for(int i = 0;i<s.length();i++){
		   ideal.put(s.charAt(i),1);
		}
		// follow the same steps of minimum window substring
		int ep = 0;
		int sp = 0;
		String ans = "";
		int anslen = s.length()+1;
		while(ep<s.length())
		{
			char ch = s.charAt(ep);
			curr.put(ch,curr.getOrDefault(ch,0)+1);
			// check whether all the ideal chars are present in curr map
			while(isValid(curr,ideal) && sp<ep)
			{   
				if(anslen>ep-sp+1){
					anslen = ep-sp+1;
					ans = s.substring(sp,ep+1);
				}
				curr.put(s.charAt(sp), curr.getOrDefault(s.charAt(sp),0) -1);
				sp++;
			}
			ep++;
			
		}

		return ans;
	
    }

	//////////////////////////////////////////////////////////////////////////////////////////

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
