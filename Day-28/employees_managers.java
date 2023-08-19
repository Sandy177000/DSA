
// hashing and recursion

public class employees_managers {
    class Solution {

        public void EmpUnderManager(Map<String, String> emp)
        {
            HashMap<String, HashSet<String>> map  = new HashMap<>();
    
            String ceo = "";
            

            // creating the map of managers and employees under that manager
            for(String employee: emp.keySet())
            {
                 String manager = emp.get(employee);
    
                 if(manager.equals(employee)){
                     ceo = manager; // if the employee reports to himself then he is the ceo
                 }
                 else{
    
                     // if the map contains the manager then add employee to his employee set
                    if(map.containsKey(manager))
                    {
                        HashSet<String> employeeSet = map.get(manager);
                        employeeSet.add(employee);
                    }
                    else{
    
                        
                     // if the map does not contains the manager then add new employee set with employee in the map
                        HashSet<String> employeeSet = new HashSet<String>();
                        employeeSet.add(employee);
                        map.put(manager, employeeSet);
                    }
                }
            }
    
    
            // recursively calculating the employee count of each manager/employee
            find(map,ceo);
    
            for(Map.Entry<String,Integer> entry: ans.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
    
        }
        
        static TreeMap<String,Integer> ans = new TreeMap<>(); // to store the entries lexicographically
        
        public static int find(HashMap<String,HashSet<String>> map,String manager)
        {		
            // base case : when the manager is not present in the map, which means employee manages none
            if(!map.containsKey(manager))
            {   ans.put(manager,0); // zero employees under the manager
                return 1; 
            }
    
            int size = 0;
            // iterating in the map of managers:[set of employees] eg: F :[C,E]
            for(String employee: map.get(manager))
            {
                size+=find(map,employee);// recursive call for the employee in the set as manager and
                                           //storing the size/number of employees under manager
            }
    
            ans.put(manager,size); // storing the manager : employees count in map
    
            return size+1; 
        }
    }
    
}
