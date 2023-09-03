public class identical_subtree {
class Solution {
    
    public boolean isIdentical(TreeNode root, TreeNode subRoot)
    {
        // if the both the nodes are null
        if(root==null && subRoot==null)
        { 
            return true;   
        }
        // if anyone of the nodes is null or the values do not match
        else if(root == null || subRoot == null || root.val!=subRoot.val){
            return false;
        }

        if(!isIdentical(root.left, subRoot.left))
        {
             return false;
        }
 
        if(!isIdentical(root.right, subRoot.right))
        {
            return false;
        }

        return true;

    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        // find the root node of the subroot lying in the main tree
        if(root.val==subRoot.val){
            // check if the remaining part of the tree is identical
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        // checking in left side and right side of the main tree
        return  isSubtree(root.left, subRoot) ||  isSubtree(root.right, subRoot);
        
    }
}  
}
