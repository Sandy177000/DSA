public class palindrome_partition 
{
    class Solution {
        public List<List<String>> partition(String s) {
            
            List<String> list = new ArrayList<>();
            List<List<String>> result = new ArrayList<>();
    
            helper(s,0,list,result);
    
            return result;
        }
    
        public void helper(String ques, int index, List<String> list,List<List<String>> res){
            
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
        public boolean isPalindrome(String ques, int start, int end){
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
}
