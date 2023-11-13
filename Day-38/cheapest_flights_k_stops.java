public class cheapest_flights_k_stops {
    class Solution {
        class Info{
            int psf;
            int node;
            int steps;
            Info(int node, int psf, int steps){
                this.node = node;
                this.psf = psf;
                this.steps = steps;
            }
        }
    
        class Pair{
            int psf;
            int node;
            Pair(int node, int psf){
                this.node = node;
                this.psf = psf;
            }
        }
    
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            
            ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
            for(int i =0;i<n;i++){
                graph.add(new ArrayList<>());
            }
    
            for(int i =0;i<flights.length;i++){
                int u = flights[i][0];
                int v = flights[i][1];
                int p = flights[i][2];
                graph.get(u).add(new Pair(v,p));
            }
    
            Queue<Info> q = new LinkedList<>();
            q.add(new Info(src,0,0));
    
            int[] arr = new int[n];
            for(int i = 0;i<arr.length;i++) arr[i] = Integer.MAX_VALUE;
            arr[src] = 0;
    
            while(!q.isEmpty()){
                
                Info  curr = q.remove();
    
                if(curr.steps>k) continue;
    
                for(Pair nbr:graph.get(curr.node))
                {
                    int node = nbr.node;
                    int psf = nbr.psf;
                    // visit the nbr only if the steps taken are less than equal to k and price to reach is min than prev 
                    if(arr[node]> psf+curr.psf && curr.steps<=k){
                        arr[node] = psf+curr.psf;
                        q.add(new Info(node,psf+curr.psf,curr.steps+1));
                    }
                }
    
            }
            
            return (arr[dst]==Integer.MAX_VALUE)?-1 : arr[dst];
    
        }
    }   
}
