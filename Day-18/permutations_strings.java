public class permutations_strings {
    public static void permuteStrings(String ques,String ans ,boolean[] visited,ArrayList<String> permuteSeq){

        if(ques.length()==ans.length()){
            permuteSeq.add(ans);
            return;
        }
        for(int i=0;i<ques.length();i++){
            if(!visited[i]){
                visited[i] = true;
                permuteStrings(ques,ans +ques.charAt(i),visited, permuteSeq);
                //backtracking no need to remove or add as in arrays
                visited[i] = false;
            }
        }
    }
}
