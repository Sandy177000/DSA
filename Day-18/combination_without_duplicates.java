public class combination_without_duplicates {
    class Solution {

        // combination problem
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            
            Arrays.sort(candidates);
            int n = candidates.length;
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            solve(candidates,0,target,list,ans);
    
            return ans;
        }
    
        public void solve(int[] arr,int index, int target,List<Integer> list,List<List<Integer>> ans){
    
    
            if(target==0)
            {  
               ans.add(new ArrayList<>(list));
               return;
            }
    
            for(int i=index;i<arr.length;i++) 
            // note: i = index is used for combinations if i = 0 is used we get permutations
            // another way would be to use a while loop after remove step in backtracking while(arr[i]==curr && i<arr.length) i++
            {
                if(i>index && arr[i-1] == arr[i] ) continue; // skipping the adjacent repetitve element
                
                if(arr[i]>target) break;
                
                list.add(arr[i]);
                solve(arr,i+1,target-arr[i], list,ans);
                list.remove(list.size()-1);
                
            }
        }
    }
}
