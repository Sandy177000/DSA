
class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}


public class floor_and_ceil_value {

    
    Pair getFloorAndCeil(int[] arr, int n, int x)
    {
       
       int floor = -1;
       int ceil = -1;
       
       int min = Integer.MAX_VALUE;
       
       for(int i=0;i<n;i++){
           if(arr[i]<=x){
               floor = Math.max(floor,arr[i]);
           }
            
           if(arr[i]>=x){
               ceil = arr[i];
               if(ceil<min){
                   min = ceil;
               }
               
            }
       }
       
       if(min==Integer.MAX_VALUE){
           min = -1;
       }
       
       
       Pair p = new Pair(floor,min);
       return p;
     
    }
}