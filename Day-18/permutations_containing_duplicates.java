public class permutations_containing_duplicates {

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) 
        {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(nums);
            solve(nums,0,ans,list, new boolean[nums.length]);
            
            return ans;    
        }
        public static void solve( int[] nums,int index, List<List<Integer>> ans, List<Integer> list,boolean[] vis)
        {
            
            if(list.size()==nums.length)
            {
                ans.add(new ArrayList<>(list));
                return;
            }
            
            
            for(int i=0;i<nums.length;i++)
            {
                if(vis[i]||(i>0 && nums[i]==nums[i-1] && !vis[i-1])) // similar logic used in combinations problem to skip adjacent duplicates
                {
                    continue;
                }
                    vis[i] = true;
                    list.add(nums[i]);
                    solve(nums,index+1, ans,list,vis);
                    list.remove(list.size()-1);
                    vis[i] = false;
            }    
            
            
        }
    }
}