public class combination {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            helper(candidates,0,target,0,list,res);
            return res;
        }
    
        public void helper(int[] arr, int index,int target, int sum, List<Integer> list,List<List<Integer>>res) 
        {
    
            if(index==arr.length){
                return;
            }
            if(sum>target){
                return;
            }
    
            if(target==sum)
            {
                res.add(new ArrayList<>(list));
                return;
            }
    
                //pick (if you moved index this problem would be similar to subsets ;))
                list.add(arr[index]);
                helper(arr,index,target,sum+arr[index],list,res);
                list.remove(list.size()-1); // backtrack
    
                //do not pick and move
                helper(arr,index+1,target,sum,list,res);
        }
    
    }
}
