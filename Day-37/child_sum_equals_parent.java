public class child_sum_equals_parent {
    ******************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
        // Write your code here.
        return solve(root);
    }

    public static boolean solve(Node root){

        if(root==null) return true;
        
        //leaf node
        if(root.left==null && root.right==null) return true;


        if(root.left!=null && root.right==null){
            int sum = root.left.data;
            if(sum!=root.data){
                return false;
            }
        }
        
        if(root.left==null && root.right!=null){
            int sum = root.right.data;
            if(sum!=root.data){
                return false;
            }
        }

        if(root.left!=null && root.right!=null){
            int sum = root.left.data + root.right.data;
            if(sum!=root.data){
                return false;
            }
        }

        return solve(root.left) && solve(root.right);

    }
}




}
