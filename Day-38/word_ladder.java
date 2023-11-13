public class word_ladder {
    class Solution {
        class Pair{
            String x;
            int steps;
            Pair(String x, int steps){
                this.x = x;
                this.steps = steps;
            }
        }
    

        // BFS 
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<Pair> q = new LinkedList<>();
            HashSet<String> set = new HashSet<>();
    
            for(String word:wordList){
                set.add(word);
            }
    
            q.add(new Pair(beginWord,1));
    
            while(!q.isEmpty()){
                Pair curr = q.remove();
                String word = curr.x;
                
                if(word.equals(endWord)) return curr.steps;
    
                // for each character in the word replace that character
                //  with all the other chars from a-z and check whether it is valid word
                for(int i = 0;i<word.length();i++){
                    char c = word.charAt(i);
                    char[] arr = word.toCharArray();
                    for(char ch = 'a'; ch<='z';ch++){
                        arr[i] = ch;
                        String newWord = String.valueOf(arr);
                        if(set.contains(newWord)){
                            set.remove(newWord);
                            q.add(new Pair(newWord,curr.steps+1)); // add to the queue only if a valid word is found  and increase the steps by 1
                                                                   //  then find out the all the possiblities of this new word again
                        }
                    }
                }
            }
            return 0;
        }
    }
}
