public class pre_in_post_traversals_BT {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    int state;
    TreeNode node;
    Pair(TreeNode node, int state){
        this.node = node;
        this.state = state;
    }
}

class Solution {

    // iterative Depth-First-Search traversals using custom stack mimicing the recursive stack
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<Pair> st = new Stack<>();
        List<Integer> preorder = new ArrayList<>();
        
        List<Integer> inorder = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root==null) return preorder;

        st.push(new Pair(root,1));
        while(!st.isEmpty())
        {
            Pair curr = st.peek();
            if(curr.state==1){
                curr.state++;
                preorder.add(curr.node.val);
                if(curr.node.left!=null){
                    st.push(new Pair(curr.node.left,1));
                }
            }
            else if(curr.state==2)
            {
                curr.state++;
                inorder.add(curr.node.val);
                if(curr.node.right!=null){
                    st.push(new Pair(curr.node.right,1));
                }
            }
            else{
                post.add(curr.node.val);
                st.pop();
            }
        }

        return preorder; 
        
       // return inorder; 
        //return post; 
    }
}
}
