public class reverse_words_in_a_sentence {
    public String reverseWords(String s) {
        
        String[] str=s.split(" ");


        StringBuilder sb =new StringBuilder();

        for(int i=str.length-1;i>=0;i--)
        {//start from last index of array
            if(str[i] !=""){
                
                sb.append(str[i]);//add word

                sb.append(" ");//add space 

                }
        }
        
        sb.setLength(sb.length()-1);//delete last space by reducing size
        return sb.toString();
    }
}
