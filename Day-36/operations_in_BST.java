public class operations_in_BST {
    
  public static int size(Node node) {
    // write your code here
	  if(node==null) return 0;
	  return size(node.left) + size(node.right)+1;
	  
  }

  public static int sum(Node node) {
    // write your code here
	  if(node==null) return 0;

	  return sum(node.left) + sum(node.right) + node.data;
  }

  public static int max(Node node) {
    // write your code here

	  if(node.right==null) return node.data;

	  return  max(node.right);
  }

  public static int min(Node node) {
    // write your code here
	  if(node.left==null) return node.data;

	  return min(node.left);
  }

  public static boolean find(Node node, int data){
    // write your code here
	  if(node==null) return false;

	  if(node.data==data) return true;

	  if(node.data>data)
	  {
        return find(node.left,data);
	  }
	  else{
		return find(node.right,data);
	  }

  }  

}
