import java.util.ArrayList;
import java.util.Collections;

//Function to find the leaders in the array.
    
public class leaders_in_array {
    
//-----------------------------Optimal------------------------------
    static ArrayList<Integer> leaders1(int arr[], int n){
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int max = arr[n-1];
        
        for(int i=n-1;i>=0;i--){

            if(arr[i]>=max){
                max = arr[i]; // updating the maximum
                list.add(arr[i]);
            }
        }
        
        Collections.reverse(list);
        
        return list;
        
    }


//----------------------Brute force approach (TLE)------------------
    static ArrayList<Integer> leaders(int arr[], int n){
        
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n-1;i++){
            boolean flag = true;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(arr[i]);
            }
        }
        list.add(arr[n-1]);
        
        return list;
    }

}
