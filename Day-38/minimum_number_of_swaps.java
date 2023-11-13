public class minimum_number_of_swaps {
    
    static int MinimumSwapsToSort(int n, int[] nums){

        Info[] temp = new Info[n];
        
        for(int i = 0;i<n;i++) temp[i] = new Info(nums[i],i);
        
        Arrays.sort(temp,(a,b)-> a.val-b.val);
        
        int c  = 0;

        boolean[] vis = new boolean[n];
        
        for(int i = 0;i<n;i++)
        {
            if(vis[i]==true|| temp[i].idx==i){
                continue;
            }
            int j = i;
            int jumps = 0;
            // jump to its original position till we get back on the current position i
            while(vis[j]==false){
                vis[j] = true;
                jumps++;
                j = temp[j].idx;
            }
            c += (jumps-1);
        }

        return c;

    }
}
