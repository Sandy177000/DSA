import java.util.HashMap;

public class Freq_of_elements_in_array {
    public static void frequencyCount(int arr[], int N, int P)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       
       for(int i=0;i<N;i++){
           if(!map.containsKey(arr[i])){
               map.put(arr[i],1);
           }
           else{
               map.put(arr[i], map.get(arr[i])+1);
           }
       }
       
       for(int i=1;i<=N;i++){
           if(map.get(i)!= null){   
               
                arr[i-1] = map.get(i);
            }
            else{
                arr[i-1] = 0;
            }
       }
        
    }

}
