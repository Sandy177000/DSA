public class second_largest {
     int print2largest(int arr[], int n) {
        
        int small = Integer.MIN_VALUE;
        int large = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]>large)
            {
                small = large;
                large = arr[i];
            }
            else if(small<arr[i] && arr[i]!=large)
            {
                small = arr[i];
            }
        }
        
        return small;
        
    }
}
