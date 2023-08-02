class graycode
{

    class Solution
    {
        public ArrayList<String> graycode(int n)
        {
            //base case
            if(n==1)
            {
                ArrayList<String> base = new ArrayList<>();
                base.add("0");
                base.add("1");
                
                return base;
            }
            
            ArrayList<String> res = graycode(n-1); // solve for the n-1 value
            
            ArrayList<String> ans = new ArrayList<>();
            
            // traverse forward and add 0
            for(int i=0;i<res.size();i++)
            {
                ans.add("0"+res.get(i));
            }
            //traverse reverse and add 1
            for(int i=res.size()-1;i>=0;i--)
            {
                ans.add("1"+res.get(i));
            }
            
            return ans;
        }
    }

}