public class rotate_string {
    public boolean rotateString(String s, String goal) {
        
        StringBuilder sb = new StringBuilder(s);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //remove from start character
            sb.deleteCharAt(0);
            //add char at the end
            sb.append(ch);
            if(sb.toString().equals(goal)){
                return true;
            }
        }

        return false;
    }

    //brute force
    public boolean rotateString2(String s, String goal) {
        if(s.equals(goal)){
            return true;
        }
        for(int i=0;i<s.length();i++){
             s = rotate(s);
             System.out.println(s);
            if((s).equals(goal)){
                return true;
            }
            
        }

        return false;
    }

    public String rotate(String s)
    {
        char arr[] = s.toCharArray();

        char last = arr[arr.length-1];
        for(int i=arr.length-1;i>=1;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last;

        return String.valueOf(arr);
    }

}
