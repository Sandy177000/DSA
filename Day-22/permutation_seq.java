public class permutation_seq {
    class Solution {
        public String getPermutation(int n, int k) {
            ArrayList<Integer> list = new ArrayList<>();
    
            int fact = 1;
    
            // calculate n-1 factorial and add n-1 numbers in a list
            for(int i=1;i<n;i++){
                list.add(i);
                fact*= i;
            } 
            k = k-1; // decrease the k by 1
            list.add(n); // add the last number
            String ans = "";
            while(true)
            {   // pick the k/fact th number from the list
                ans  = ans + list.get(k/fact);
                // remove the number from the list
                list.remove(k/fact);
                // if list is empty that means all the numbers are used to make the sequence
                if(list.size()==0){
                    break;
                }
                // update the k and factorial
                k = k%fact;
                fact = fact/list.size();
    
            }
    
            return ans;
        }
    }

    // brute force generate all the permutations
    class Solution {
        public String getPermutation(int n, int k) {
            
            ArrayList<String> list = new ArrayList<String>();
            solve(n,k,"",new boolean[n+1],list);
            
            return list.get(k-1);
        }
    
    
        public void solve(int n,int k,String ans,boolean[] vis,ArrayList<String> list){
    
    
            if(ans.length()==n){
                
                list.add(ans);
                return;
            }
            
            if(list.size()>k)
            {
                return;
            }
    
            for(int i = 1; i<=n;i++)
            {
                if(!vis[i])// to get unique permutations
                {
                    vis[i] = true;
                    solve(n,k,ans+""+i,vis,list);
                    vis[i] = false;
                }
    
            }
    
        }
    }
}
