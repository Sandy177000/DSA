public class letter_tiles_sequences_possible {

    // permutation problem
    class Solution {
        public int numTilePossibilities(String tiles) {
            
                HashSet<String> list = new HashSet<String>(); // set is used instead of arrayList
                permuteStrings(tiles,"",new boolean[tiles.length()], list);
                return list.size()-1;
    
        }
        public static void permuteStrings(String ques,String ans ,boolean[] visited, HashSet<String> permuteSeq){
    
            permuteSeq.add(ans);
    
            for(int i=0;i<ques.length();i++)
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    permuteStrings(ques,ans +ques.charAt(i),visited, permuteSeq);
                    visited[i] = false;
                }
            }
        }
    }
}
