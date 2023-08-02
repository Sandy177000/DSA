public class rat_in_a_maze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        ArrayList<String> ans = new ArrayList<>();
        solve(m,n, new boolean[n][n],0,0,"",ans);
        
        if(ans.size()==0){
            ans.add("-1");
            return ans;
        }
        return ans;
    }
    public static void solve(int[][] arr, int n, boolean[][] vis, int i, int j, String path, 
                             ArrayList<String> ans)
    {
        if(i==n-1 && j==n-1)
        {
            if(arr[i][j]!=0)
                 ans.add(path);
            return;
        }
        
        if(i<0 || j<0 || j>n-1 || i>n-1 || vis[i][j] || arr[i][j]==0){
            return ;
        }
        
        
        
        vis[i][j] = true;
        solve(arr,n,vis,i,j+1,path+"R",ans);
        solve(arr,n,vis,i,j-1,path+"L",ans);
        solve(arr,n,vis,i-1,j,path+"U",ans);
        solve(arr,n,vis,i+1,j,path+"D",ans);
        vis[i][j] = false;
        
    }
}
