import java.util.*;

public class isomorphic_strings {

    //brute force
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> map = new HashMap<Character,Character>();

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(!map.containsValue(t.charAt(i)))
                     map.put(s.charAt(i),t.charAt(i));
            }
        }

        StringBuilder x = new StringBuilder();
        for(int i=0;i<s.length();i++){
            x.append(map.get(s.charAt(i)));
        }

        if(x.toString().equals(t))
            return true;
        

        return false;
    }
}
