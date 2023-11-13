public class course_schedule_2 {
    class Solution {
        public int[] findOrder(int N, int[][] adj) {
    
                // topological sort using kahn algorithm
                ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
                int[] dependencies = new int[N];
    
                for(int i = 0;i<N;i++){
                    graph.add(new ArrayList<>());
                }
    
                for(int i = 0;i<adj.length;i++){
                    int u = adj[i][0];
                    int v = adj[i][1];
                    dependencies[v]++;
                    graph.get(u).add(v);
                }
    
                boolean[] vis = new boolean[N];
    
                ArrayList<Integer> topo = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                
                for(int i = 0;i<N;i++){
                    if(dependencies[i]==0) q.add(i);
                }
    
                while(!q.isEmpty()){
                    int curr = q.remove();
                    topo.add(curr);
                    for(int nbr:graph.get(curr))
                    {
                        dependencies[nbr]--;
                        if(dependencies[nbr]==0)
                           q.add(nbr);
                    }
                }
    
                //  cycle is present 
                if(topo.size()<N) return new int[0];
    
    
                int[] ans = new int[N];
                for(int i = 0;i<N;i++){
                    ans[i] = topo.get(N-i-1);
                }
    
                return ans;

        }
    }
}
