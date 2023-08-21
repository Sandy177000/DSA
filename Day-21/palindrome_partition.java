public class palindrome_partition {
    public static ArrayList<ArrayList<String>> PalindromePartitioning(String s) {
        
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		helper(s,0,list,res);

		return res;
    }
    public static void helper(String ques, int index, ArrayList<String> list,ArrayList<ArrayList<String>> res){
            
            if(index==ques.length())
            {
                res.add(new ArrayList<>(list));
                return;
            }
    
            for(int i=index;i<ques.length();i++)
            {
                if(isPalindrome(ques,index,i))
                {
                    list.add(ques.substring(index,i+1));// storing the part 
                    helper(ques,i+1,list,res); // call for next part
                    //backtracking
                    list.remove(list.size()-1);
                }
            }
        }
    public static boolean isPalindrome(String ques, int start, int end){
            while(start<=end){
                if(ques.charAt(start)!=ques.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
    
            return true;
        }

}
