public class longest_common_prefix {
    //brute force
    public String longestCommonPrefix(String[] str) {
        int len = Integer.MAX_VALUE;
        for(int i=0;i<str.length;i++){
            len = Math.min(len,str[i].length());
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<len;i++){
            char c = str[0].charAt(i);
            for(int j=0;j<str.length;j++){
                if(c!=str[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();

        
    }    
}
