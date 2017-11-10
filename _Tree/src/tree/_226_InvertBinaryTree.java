package tree;

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
        if(n==null) return null;
        TreeNode l = invertTree(n.left);
        TreeNode r = invertTree(n.right);
        n.right = l;
        n.left  = r;
        return n;
    }
}