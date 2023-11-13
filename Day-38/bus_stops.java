class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0;i<routes.length;i++){
            for(int j = 0;j<routes[i].length;j++){
                 int stop = routes[i][j];
                 ArrayList<Integer> list = map.getOrDefault(stop,new ArrayList<Integer>());
                 list.add(i);
                 map.put(stop,list);
            }   
        }

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        HashSet<Integer> visitedBuses = new HashSet<>();
        queue.add(source);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i<size;i++){

                 int stp = queue.remove();

                 if(stp==target) return level;

                 ArrayList<Integer> buses = map.get(stp); // finding all the buses which stops at stp
                 
                 // selecting each bus
                 for(int bus:buses){

                     if(visitedBuses.contains(bus)) continue;
                     
                     // visiting all the stops a bus can visit
                     for(int stop: routes[bus]){
                        
                        if(visitedStops.contains(stop)) continue;
                
                        queue.add(stop); 
                        
                        visitedStops.add(stop);
                     }

                     visitedBuses.add(bus); 
                 }

                 
            }
            level++;
        }

        return -1;
    }
}