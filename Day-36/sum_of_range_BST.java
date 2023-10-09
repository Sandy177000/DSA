public class sum_of_range_BST {
    
    class ans{
        long ans = 0;
    }

    class Solution
    { 
        // non static variable access by creating a object
        ans a = new ans();
        
        long rangeSum(Node root, int l, int r)
        { 
            //DFS technique-inorder/preorder/postorder traversal 
            if(root!=null)
            {
                    if(root.data>=l && root.data<r){
                        a.ans+= root.data;
                    }
                
                    rangeSum(root.left,l,r);
                    rangeSum(root.right,l,r);
            }
            
            return a.ans;
        } 
    }
}
