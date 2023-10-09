public class bst_iterator {
    class BSTIterator {

        Stack<TreeNode> st;
        public void add(TreeNode node){
            while(node!=null){
                st.add(node);
                node = node.left;
            }
        }
        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            add(root);// add all the left nodes in the stack and move the pointer to the left
        }
        
        public int next() {
            TreeNode res = st.pop();
            add(res.right); // add all the left nodes of the right node
            return res.val;
        }
        
        public boolean hasNext() {
            return !st.isEmpty();
        }
    }
}
