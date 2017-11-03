package tree;

public class _101_SymmetricTree {

	public static void main(String[] args) {
		_101_SymmetricTree obj = new _101_SymmetricTree();
		
		TreeNode tree1 = TreeNode.arrayToTree(new Integer[] { 1, 2, 2, 3, null, null, 3 });  //symmetric
		TreeNode tree2 = TreeNode.arrayToTree(new Integer[] { 1, 2, 3, 3, null, 2, null });  //non-symmetric
		System.out.println(obj.isSymmetric(tree1));
		System.out.println(obj.isSymmetric(tree2));
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left != null && right != null) {
			if (left.val != right.val)
				return false;
			if (!isSymmetric(left.left, right.right))
				return false; // outer
			if (!isSymmetric(left.right, right.left))
				return false; // inner
		}
		return true;
	}
}
