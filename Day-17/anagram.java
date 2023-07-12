import java.util.*;

public class anagram {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
        {
            return false;
        }

        char A[] = s.toCharArray();
        char B[] = t.toCharArray();
 
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            if(A[i]!=B[i]){
                return false;
            }
        }

        return true;
    }    
}
