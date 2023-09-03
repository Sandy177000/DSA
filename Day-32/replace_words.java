public class replace_words {
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            
            HashSet<String> set = new HashSet<>();
            String[] arr = sentence.split(" ");
            for(String x: dictionary){
                set.add(x);
            }
    
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++)
            {
                String y = arr[i];
                String x = "";
                boolean match = false;
                for(int j = 0;j<y.length();j++){
                    
                    x+=y.charAt(j);
    
                    // finding the match in the set
                    if(set.contains(x)){
                        System.out.println(x);
                        sb.append(x);
                        sb.append(" ");
                        match = true;
                        break;
                    }
                }
    
                if(!match){
                    sb.append(arr[i]);
                    sb.append(" ");
                }
            }
    
            return sb.toString().trim();
    
    
        }
    }
}
