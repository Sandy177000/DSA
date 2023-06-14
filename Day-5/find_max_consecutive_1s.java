public class find_max_consecutive_1s {

     public int findMaxConsecutiveOnes(int[] arr) {
         int count = 0;
         int n = arr.length;
         int max = 0;

         for(int i=0;i<n;i++){
            // check for zeros instead of one
             if(arr[i]==0){
                 if(max<count){
                     max = count;
                 }
                 count = 0;
             }
             else{
                 count++;
             }
         }

         max = Math.max(max,count);
        
         return max;

    }
}
