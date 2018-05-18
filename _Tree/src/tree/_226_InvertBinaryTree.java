package tree;
/* 
 * Input:
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9

	Output:
	
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
 */
public class _226_InvertBinaryTree {

	public static void main(String[] args) {
		_226_InvertBinaryTree obj = new _226_InvertBinaryTree();
		
		TreeNode t1 = TreeNode.getDefaultTree();
		t1.printBFS();
		
		TreeNode t2 = obj.invertTree(t1);
		t2.printBFS();
		
		TreeNode t3 = obj.invertTree(t2);
		t3.printBFS();
	}
    public TreeNode invertTree(TreeNode n) {
        if(n==null) return n;
        
        /* swap left and right */
        TreeNode temp = n.right; 
        n.right=invertTree(n.left);
        n.left =invertTree(temp);
        return n;
    }
}