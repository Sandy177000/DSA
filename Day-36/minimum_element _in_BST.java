/**
 * minimum_element _in_BST
 */
public class minimum_element_in_BST {

    class Solution{
        public int minimumNode(Node root){
            if(root.left==null) return root.val;

            return minimumNode(root.left);
        }
    }
}