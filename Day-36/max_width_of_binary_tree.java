public class max_width_of_binary_tree {
 
class Solution {

    class Pair{
        int id;
        TreeNode node;
        Pair(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int max = 0;

        while(!q.isEmpty()){
            int n = q.size();

            int sp = 0; int ep = 0;
            for(int i =0;i<n;i++)
            {
                Pair cur = q.remove();
                int cur_id = cur.id;
                TreeNode curr = cur.node;

                if(i==0){
                    sp = cur_id; // storing the index of the first element in queue/level
                }
                if(i==n-1){
                    ep = cur_id; // storing the index of the last element in queue/level
                }

                // to calculate the index of the left child of parent node =  parent*2+1
                // index of the right child of parent node = parent*2+2

                if(curr.left!=null)
                { 
                    q.add(new Pair(curr.left,cur_id*2+1)); // storing the node and its index
                }
                if(curr.right!=null) 
                {  
                    q.add(new Pair(curr.right,cur_id*2+2)); // storing the node and its index
                }
            }

            max = Math.max(max,ep-sp+1); // storing the diff between the extreme nodes
        }

        return max;
    }
}   
}
