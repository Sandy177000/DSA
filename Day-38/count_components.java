public class count_components {

    class Solution {
        public int findCircleNum(int[][] graph) {
            
            // dfs and mark all the visited nodes 
            // increase count after each call for bfs
    
            boolean[] vis = new boolean[graph.length];
    
            int c = 0;
            for(int i = 0;i<graph.length;i++){
                if(!vis[i])
                {   
                    dfs(graph,i,vis);
                    c++;
                }
            }
    
            return c;
    
        }
    
        public static void dfs(int[][] graph,int src, boolean[] vis){
            vis[src] = true;
            for(int nbr = 0;nbr<graph.length;nbr++){
                        // valid nbr
                        if(graph[src][nbr]==1 && nbr!=src){
                            if(!vis[nbr]){ // should be unvisited
                                dfs(graph,nbr,vis);
                            }
                        }
            }        
        }
    }

    // using disjoint set technique0
    class Solution 
    {
        class DisjointSet
        {
            int[] parent;
            int[] size;
            DisjointSet(int nodes){
                this.parent = new int[nodes];
                this.size = new int[nodes];
                
            }
    
            public int findParent(int node){
                if(node == parent[node]) return node;
    
                return parent[node] = findParent(parent[node]);
            }
    
            public void mergeNodes(int node1, int node2){
                if(size[node1]>size[node2]){
                    parent[node2] = node1;
                    size[node1] += size[node2];
                }
                else{
                    parent[node1] = node2;
                    size[node2] += size[node1];
                }
            }
        }
    
        public int findCircleNum(int[][] isConnected) {
    
            int nodes = isConnected.length;
            DisjointSet ds = new DisjointSet(nodes);
          
            for(int i =0;i<nodes;i++)
            {
                    ds.parent[i] = i;
                    ds.size[i] = 1;
            }
    
            for(int i =0;i<nodes;i++){
                for(int j = 0;j<nodes;j++){
                    if(isConnected[i][j]==1){
                        int p1  = ds.findParent(i);
                        int p2 =  ds.findParent(j);
                        if(p1!=p2){
                            ds.mergeNodes(p1,p2);
                        }
                    }
                }
            }
    
            // find the node which has itself as the parent and count them
            int provinces = 0;
            for(int i =0;i<nodes;i++)
            {
                if(ds.parent[i]==i) provinces++;
            }
    
            return provinces;
    
        }
    }
}
