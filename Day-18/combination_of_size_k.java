public class combination_of_size_k {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            
            int[] arr = {1,2,3,4,5,6,7,8,9};
            List<List<Integer>> ans = new ArrayList<>();
    
            solve(arr,k,0,n, new boolean[10], new ArrayList<Integer>(),ans);
    
            return ans;
        }
    
        public void solve(int[] arr, int k, int index, int sum,boolean[] used, List<Integer> list, List<List<Integer>> ans){
    
            if(sum==0)
            {
                if(list.size()==k)
                {
                    ans.add(new ArrayList<Integer>(list));
                }
    
                return;
            }
    
            for(int i=index;i<arr.length;i++)
            {
                if(!used[i])
                {   used[i] = true;
                    list.add(arr[i]);
                    solve(arr,k,i+1,sum-arr[i],used,list,ans);
                    used[i] = false;
                    list.remove(list.size()-1);
                }
            }
    
    
        }
    }
}
