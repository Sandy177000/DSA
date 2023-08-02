public class diff_ways_to_add_paranthesis_and_compute {
    class Solution {

        public List<Integer> diffWaysToCompute(String expression) 
        {
            
            List<Integer> ans = new ArrayList<Integer>();
    
            for(int i=0;i<expression.length();i++)
            {
                char ch = expression.charAt(i);
    
                // find the operator
                if(ch=='+'||ch=='*'||ch=='-')
                {
                    // split it into two halves similar to palidrome partition problem
                    String left = expression.substring(0,i);
                    
                    String right = expression.substring(i+1);
    
                    // call for both the parts
                    List<Integer> a = diffWaysToCompute(left);
                    
                    List<Integer> b = diffWaysToCompute(right);
    
                    // calculate the ans and add
                    for(int j = 0; j<a.size();j++)
                    {
                        for(int k =0;k<b.size();k++)
                        {
                            if(ch=='-'){
                                int x = (int)(a.get(j) - b.get(k));
                                ans.add(x);
                            }
                            else if(ch=='+'){
                                int y = (int)(a.get(j) + b.get(k));
                                ans.add(y);
                            }
                            else if(ch=='*'){
                                int z = (int)(a.get(j) * b.get(k));
                                ans.add(z);
                            }
                        }
                    }
    
                }
    
            }
    
            // no operator found, base case
            if(ans.size()==0){
                ans.add(Integer.parseInt(expression));
            } 
            
            return ans;
        }
    }
}
