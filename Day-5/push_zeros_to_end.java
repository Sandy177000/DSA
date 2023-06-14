public class push_zeros_to_end {
    void pushZerosToEnd(int[] arr, int n) {

        int index = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[index] = arr[i];
                index++;
            }
        }
        for(int i=index;i<n;i++){
            arr[index] = 0;
            index++;
        }
    }
}
