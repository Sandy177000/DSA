public class longest_substring_with_k_unique_chars {
    
    public static int longestkSubstr(int n, int k,String s){

		int ans = 0;
		int i = -1;
		int j = -1;

		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true)
		{
			boolean first = false;
			boolean second = false;
			// including chars in the window
			while(i<s.length()-1){
				first = true;
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch,0)+1);

				//////////////////////////
				if(map.size()<k)
				{
					continue;
				}	
				// ans found with k distinct characters
				else if(map.size()==k) {
					int len = i-j;
					if(len>ans){
						ans = len;
					}
				}
				else {
					break;
				}
				///////////////////////////
			}

			//removing chars
			while(j<i){
				
				second = true;
				j++;
				char ch = s.charAt(j);

				if(map.get(ch)==1){
					map.remove(ch);
				}
				else{
					map.put(ch, map.getOrDefault(ch,0)-1);
				}

				////////////////////////////////
				// continue removing elements
				if(map.size()>k){
					continue;
				}

				// ans found
				else if(map.size()==k){
					ans = Math.max(ans,i-j);
					break;
			   }
				/////////////////////////////////

			}

			if(!first && !second){
				break;
			}
		}

		return ans!=0?ans:-1;
    }


}
