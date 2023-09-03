

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        
        ArrayList<Integer> list =  new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // making the map of first k elements
        
        for(int i=0;i<=k-2;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        
        
        for(int j = 0, i = k-1;i< A.length;)
        {
        
            // increasing the size of the window
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            
            list.add(map.size());
            
            // decreasing the size of the window
            if(map.get(A[j])==1){
                map.remove(A[j]);
            }
            else{
                map.put(A[j], map.get(A[j])-1);
            }
            
            i++;
            j++;
            
        }
        
        return list;
    
                
        
    }
}