class possible_paths{

    class Solution
    {
        public int MinimumWalk(int[][] graph, int u, int v, int k)
        {
            return dfs(graph,u,v, new int[graph.length][k+1],k);
        }
        
        public int dfs(int[][] graph, int src, int dest, int[][] dp, int k)
        {
            if(k==0){
                if(src==dest) return 1;
                
                return 0;
            }
            
            if(dp[src][k]!=0) return dp[src][k];
            
            int ans = 0 ;
            for(int i = 0;i<graph[0].length;i++){
                if(graph[src][i]==1){
                    ans = (ans + solve(graph,i,dest,dp,k-1))%1000000007;
                }
            }
            return dp[src][k] = ans%1000000007; // storing the path counts if already calculated 
        }
    }
}