public class largest_BST {

public class Solution {
    static class Info{

        int low;
        int high;
        int size;
        Info(int low, int high, int size){
            this.low = low;
            this.high = high;
            this.size = size;
        }
    }

    public static int largestBST(TreeNode root) {
        return solve(root).size;
    }

    public static Info solve(TreeNode root){

        if(root==null) return new Info(Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        // post order traversal 
        Info left = solve(root.left);
        Info right = solve(root.right);

        // valid node of bst found update limits it can have
        if(root.data>left.high && root.data<right.low){
            return new Info(
                            Math.min(left.low,root.data), // lower limit
                            Math.max(right.high,root.data), // upper limit
                            left.size+right.size+1 // size of the bst
                        );
        }

        return new Info(Integer.MIN_VALUE,
                        Integer.MAX_VALUE,
                        Math.max(left.size,right.size)); // update the size of the bst as max of left and right
    }
}















}
