public class number_of_ways_to_arrive {
    class Solution {
    
        public static class Pair{
            int node ;
            long time ;
            Pair(int node, long time){
                this.node = node;
                this.time  = time;
            }
        }
        public static int countPaths(int n, int[][] roads){
    
            ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
            for(int i = 0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            for(int[] road:roads){
                int u = road[0];
                int v = road[1];
                int time = road[2];
                graph.get(u).add(new Pair(v,time));
                graph.get(v).add(new Pair(u,time));
            }
            return minPath(graph,n);
        }
    
        public static int minPath(ArrayList<ArrayList<Pair>> graph, int n)
        {
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
            pq.add(new Pair(0,0));
            long[] time = new long[n];
            int[] ways = new int[n];
            
            for(int i = 0;i<n;i++){
                time[i] = Long.MAX_VALUE;
                ways[i] = 0;
            }
            
            time[0] = 0;		
            ways[0] = 1;
            
            while(!pq.isEmpty())
            {
                Pair curr = pq.remove();
                for(Pair nbr:graph.get(curr.node)){
                    // finding the min time to reach nbr and store the ways to reach each nbr
                    if(time[nbr.node] > nbr.time + curr.time){
                        time[nbr.node] = (nbr.time + curr.time);// time so far
                        pq.add(new Pair(nbr.node, time[nbr.node]));
                        ways[nbr.node] = (ways[curr.node])%1000000007; // ways so far
                    }
                    // min time to reach, found again
                    else if(time[nbr.node]==nbr.time+curr.time){
                        ways[nbr.node] = (ways[nbr.node] + ways[curr.node])%1000000007; // ways so far updated // incrementing in previously reached ways
                    }
                }
            }
            return ways[n-1]%1000000007;
    }
    
    }
}
