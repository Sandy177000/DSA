import java.util.*;

public class find_union {
    
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        HashSet<Integer> set = new HashSet<Integer>(n+m);
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }
        ArrayList<Integer> l =  new ArrayList<>(n+m);
        l.addAll(set);
        
        Collections.sort(l);
        
        return l;
    }
    


}
