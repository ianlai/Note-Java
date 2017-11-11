package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _230_KthSmallestElementInABST {

	public static void main(String[] args) {
		_230_KthSmallestElementInABST obj = new _230_KthSmallestElementInABST();
		TreeNode tree = TreeNode.getBST();
		tree.printBFS();
		int k1 = 7;
		int e1 = obj.kthSmallest(tree, k1);
		int k2 = 1;
		int e2 = obj.kthSmallest(tree, k2);
		System.out.println(k1 + ": " + e1);
		System.out.println(k2 + ": " + e2);
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		return list.get(k - 1);
	}

	public void inorder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		if (node.left != null) {
			inorder(node.left, list);
		}
		list.add(node.val);
		if (node.right != null) {
			inorder(node.right, list);
		}
	}
}