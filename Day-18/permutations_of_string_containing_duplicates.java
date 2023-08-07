public class permutations_of_string_containing_duplicates {
    
class Solution {
    public List<String> find_permutation(String S) 
    {        
        List<String> permuteSeq = new ArrayList<>();
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(char c:arr)
        {
            sb.append(c);    
        }
        permuteStrings(sb.toString(),"",new boolean[S.length()],permuteSeq);
        
        return permuteSeq;
    }
    
    public static void permuteStrings(String ques,String ans ,boolean[] visited,List<String> permuteSeq)
    {

        if(ques.length()==ans.length()){
            permuteSeq.add(ans);
            return;
        }
        for(int i=0;i<ques.length();i++)
        {
            if(visited[i]||(i>0 && !visited[i-1] && ques.charAt(i)==ques.charAt(i-1))) continue; // important step to check whether  we have visited the same char before
        
                visited[i] = true;
                permuteStrings(ques,ans +ques.charAt(i),visited, permuteSeq);
                visited[i] = false;
            
        }
    }
  }
}
