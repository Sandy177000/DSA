import java.util.Arrays;

public class merge_intervals {
       public int[][] merge(int[][] arr) {
        int n = arr.length;
        //sorting array based on the start times
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int i=0;
        int j=1;

        while(j<n)
        {
            if(arr[i][1]>=arr[j][0])
            {
               // end time of prev meeting is high than curr meeting start time
               // replace the end time of prev meeting with max of curr and prev meeting's end time
               arr[i][1]= Math.max(arr[j][1],arr[i][1]);
            }
            else
            { 
                i++;

                // shift the meeting timings of curr meeting to prev meeting 
                arr[i][0]=arr[j][0];
                arr[i][1]=arr[j][1];   
            }
            j++;
        }

        // storing the i+1 merged intervals
        int[][] ans = new int[i+1][2];
        for(int k=0;k<i+1;k++)
        {
             ans[k][0]=arr[k][0];
             ans[k][1]=arr[k][1];
        }
        return ans;

    } 
}
