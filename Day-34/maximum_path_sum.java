/**
 * maximum_path_sum
 */
public class maximum_path_sum {

    
class Solution
{
    //Function to return maximum path sum from any node in a tree.
    
    int maxPath(Node node, int[] max){
        
        if(node==null) return 0;
        
        int leftSum = Math.max(0, maxPath(node.left,max));  // left max
        int rightSum = Math.max(0, maxPath(node.right,max)); // right max
        
        max[0] = Math.max(max[0], leftSum+rightSum+node.data); //
        
        return node.data + Math.max(leftSum,rightSum);
        
    }
    
    int findMaxSum(Node node)
    {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPath(node,max);
        
        return max[0];
        
    }
}
}