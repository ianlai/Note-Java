package bst;

import tree.TreeNode;

/**
 * Definition for a binary tree TreeNode. public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class _108_ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 5, 8, 9, 13, 15, 28 };
		TreeNode root = sortedArrayToBST(arr);

		System.out.println("BFS:");
		TreeNode.printBFS(root);

		System.out.println();
		System.out.println("DFS(In-order):");
		root.printInOrder();

	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		int size = nums.length;
		if (size == 0)
			return null;
		TreeNode root = createTreeNode(nums, 0, size - 1);
		return root;
	}

	private static TreeNode createTreeNode(int[] nums, int low, int high) {
		if (low > high)
			return null; // done

		int index = (low + high) / 2;
		TreeNode n = new TreeNode(nums[index]);
		n.left = createTreeNode(nums, low, index - 1);
		n.right = createTreeNode(nums, index + 1, high);
		return n;
	}

	/* This is BST but not balanced */

	// public TreeNode sortedArrayToBST(int[] nums) {
	// int size = nums.length;
	// if(size==0) return null;

	// int i = size/2;
	// TreeNode root = new TreeNode(nums[i]);
	// if(i-1 >= 0)
	// root.left = new TreeNode(nums[i-1]);
	// if(i+1 < size)
	// root.right = new TreeNode(nums[i+1]);

	// if(root.left!=null)
	// root.left.left = createTreeNode(nums, i-1-1, false);
	// if(root.right!=null)
	// root.right.right = createTreeNode(nums, i+1+1, true);

	// return root;
	// }

	// private TreeNode createTreeNode(int[] nums, int index, boolean isRightTreeNode){
	// if(index>=nums.length || index<0) return null;
	// TreeNode n = new TreeNode(nums[index]);
	// if(isRightTreeNode){
	// n.right = createTreeNode(nums, index+1, true);
	// }else{
	// n.left = createTreeNode(nums, index-1, false);
	// }
	// return n;
	// }
}