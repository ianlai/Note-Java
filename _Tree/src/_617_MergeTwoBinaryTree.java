public class _617_MergeTwoBinaryTree {

	public static void main(String[] args) {
		TreeNode tree1 = TreeNode.arrayToTree(new Integer[] { 1, 3, 2, 5 });  
		TreeNode tree2 = TreeNode.arrayToTree(new Integer[] { 2, 1, 3, null, 4, null, 7 });  
		tree1.printBFS();
		tree2.printBFS();
		TreeNode treeMerge = mergeTrees(tree1, tree2);
		treeMerge.printBFS();
	}
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) return null;
        if(t1!=null && t2==null) return t1;
        if(t1==null && t2!=null) return t2;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        return t1;
    }
}