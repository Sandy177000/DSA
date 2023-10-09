public class course_schedule {
    class Solution {
        public boolean canFinish(int N, int[][] adj) {
            
            // Kahn's algorithm
            // do topo sort and if the size of the list is equal to number of nodes then it is possible to finish the course
            // make the graph out of the 2d array given
            // make the dependency array
            // do bfs by pushing all the nodes having dependency 0
    
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i = 0;i<N;i++) graph.add(new ArrayList<>());
            int[] dependency = new int[N];
            for(int[] item: adj){
                int u = item[0];
                int v = item[1];
                dependency[u]++;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
    
            Queue<Integer> q = new LinkedList<>();
    
            for(int i = 0;i<N;i++){
                if(dependency[i]==0){
                    q.add(i);
                }
            }
    
            // bfs
            ArrayList<Integer> topo = new ArrayList<>();
            while(!q.isEmpty()){
                int curr = q.remove();
                topo.add(curr);
                for(int nbr:graph.get(curr)){
                    dependency[nbr]--;
                    // add only if the dependency or degree is zero
                    if(dependency[nbr]==0)
                        q.add(nbr);
                }
            }
    
            return topo.size()==N?true:false;
    
    
        }
    }
}
