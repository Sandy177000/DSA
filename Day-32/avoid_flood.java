public class avoid_flood {
    class Solution {
        public int[] avoidFlood(int[] rains) {
            HashMap<Integer,  Integer> map = new HashMap<>();
            TreeSet<Integer> set = new TreeSet<>(); // to store days in order
    
            int[] ans = new int[rains.length];
            Arrays.fill(ans,-1);
    
            for(int i=0;i<rains.length;i++){
                if(rains[i]==0){
                    // storing the day where there was no rain
                    set.add(i);
                }
                else{
                    if(map.containsKey(rains[i]))
                    {
    
                        Integer next = set.ceiling(map.get(rains[i])); // ceiling value of given 
                        if(next==null){
                            return new int[0];
                        }
    
                        ans[next] = rains[i]; // rain transfered to the day where there was no rain
                        set.remove(next); 
    
                    }
                    // storing the amount of rain and the its day
                    map.put(rains[i], i);
                }
            }
    
            // remaining days with no rain
    
            for(int i:set){
                ans[i] = 1;
            }
    
            return ans;
        }
    }
}
