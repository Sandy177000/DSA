/**
 * time_to_burn_tree
 */
public class time_to_burn_tree {

class Solution {
    public int amountOfTime(TreeNode root, int start) {

        if(root==null ||( root.left==null && root.right==null)) return 0;

        HashMap<TreeNode,TreeNode> parentLinks = new HashMap<>();
        // finding the startnode and storing all the parent nodes of all the tree nodes 
        TreeNode startNode = linktoParent(root, parentLinks, start);

        if(startNode==null) return 0;

        // finding the time taken to burn the tree
        return burnTree(startNode, parentLinks);

    }

    public int burnTree(TreeNode start,HashMap<TreeNode, TreeNode> parentLinks)
    {
        // level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();

        visited.put(start,true);
        int time = 0;

        queue.add(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for(int i=0;i<size;i++){

                TreeNode curr = queue.remove();

                //mark true in the map if the child node is not visited 
                if(curr.left!=null && visited.get(curr.left)==null){
                    flag = true;
                    visited.put(curr.left,true);
                    queue.add(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    flag = true;
                    visited.put(curr.right,true);
                    queue.add(curr.right);
                }

                //mark parent node as true if not visited
                TreeNode parentNode = parentLinks.get(curr);
                if(parentNode!=null && visited.get(parentNode)==null){
                    flag = true;
                    visited.put(parentNode,true);
                    queue.add(parentNode);
                }
            
            }

            if(flag) time++;
        }

        return time;
    }

    public TreeNode linktoParent(TreeNode root, HashMap<TreeNode, TreeNode> parentLinks, int start)
    {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        TreeNode startNode = null;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.remove();

                // start node found
                if(curr.val==start){
                    startNode = curr;
                }

                if(curr.left!=null)
                {   // adding the parent node for the left node in the map
                    parentLinks.put(curr.left,curr);
                    queue.add(curr.left);
                }
                
                if(curr.right!=null)
                {   // adding the parent node for the right node in the map
                    parentLinks.put(curr.right, curr);
                    queue.add(curr.right);
                }
            }
        }

        return startNode;


    }
}




















}