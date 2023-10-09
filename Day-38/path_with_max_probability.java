public class path_with_max_probability {
    // more effcient djikstra algp as we maintain a array of the probability and choose only max probability so far
    class Solution {
        public class Pair{
            int node;
            double prob;
            Pair(int node, double prob){
                this.node = node;
                this.prob = prob;
            }
        }
    
        public double maxProbability(int n, int[][] edges, double[] succProb, int src, int tar) {
            ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
            for(int i =0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            int i = 0;
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                double p = succProb[i];
                graph.get(u).add(new Pair(v,p));
                graph.get(v).add(new Pair(u,p));
                i++;
            }
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (a,b)->{
                    return Double.compare(b.prob,a.prob);
                }  
            );
    
            pq.add(new Pair(src,1));
            double ans = 0;
            double[] probability = new double[n+1];
            
            while(!pq.isEmpty()){
                Pair curr = pq.remove();
                double curr_prob = curr.prob; 
                int val = curr.node;
                if(val==tar){
                      return probability[val];
                }   
                for(Pair pair:graph.get(val)){
                        int nbr = pair.node;
                        double psf_prob = (pair.prob) * (curr_prob);
                        // adding in queue only if the probability of the nbr is greater than probability of the path so far
                        if(probability[nbr] < psf_prob)
                        {   
                             probability[nbr] = psf_prob;
                             pq.add(new Pair(nbr,psf_prob));
                        }
                }
                
            }
            return 0.0;
        }
    }
    
    // dijsktra algo
    class Solution {
        public class Pair{
            int node;
            double prob;
            Pair(int node, double prob){
                this.node = node;
                this.prob = prob;
            }
        }
    
        public double maxProbability(int n, int[][] edges, double[] succProb, int src, int tar) {
            ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
            for(int i =0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            int i = 0;
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                double p = succProb[i];
                graph.get(u).add(new Pair(v,p));
                graph.get(v).add(new Pair(u,p));
                i++;
            }
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (a,b)->{
                    return Double.compare(b.prob,a.prob);
                }  
            );
    
            pq.add(new Pair(src,1));
            double ans = 0;
            boolean[] vis = new boolean[n];

            while(!pq.isEmpty()){
                Pair curr = pq.remove();
                double curr_prob = curr.prob; 
                int val = curr.node;
                // reached target
                if(val==tar){
                    // store only the maximum probability
                    if(curr_prob>ans){
                        ans = curr_prob;
                    }
                }

                if(!vis[val]){
                    vis[val] = true;
                    for(Pair pair:graph.get(val)){
                        int nbr = pair.node;
                        double nbr_prob = (pair.prob) * (curr_prob);
                        pq.add(new Pair(nbr,nbr_prob));
                    }
                }
            }
            return ans;
        }
    }    
}
