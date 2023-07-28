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
            
            ArrayList<String> res = graycode(n-1);
            
            ArrayList<String> ans = new ArrayList<>();
            
            for(int i=0;i<res.size();i++)
            {
                ans.add("0"+res.get(i));
            }
            for(int i=res.size()-1;i>=0;i--)
            {
                ans.add("1"+res.get(i));
            }
            
            return ans;
        }
    }

}