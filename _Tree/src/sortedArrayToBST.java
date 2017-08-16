/**
 * Definition for a binary tree node. public class Node { int val; Node left;
 * Node right; Node(int x) { val = x; } }
 */
public class sortedArrayToBST {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 5, 8, 9, 13, 15, 28 };
		Node root = sortedArrayToBST(arr);

		System.out.println("BFS:");
		Node.printBFS(root);

		System.out.println();
		System.out.println("DFS(In-order):");
		root.printInOrder();

	}

	public static Node sortedArrayToBST(int[] nums) {
		int size = nums.length;
		if (size == 0)
			return null;
		Node root = createNode(nums, 0, size - 1);
		return root;
	}

	private static Node createNode(int[] nums, int low, int high) {
		if (low > high)
			return null; // done

		int index = (low + high) / 2;
		Node n = new Node(nums[index]);
		n.left = createNode(nums, low, index - 1);
		n.right = createNode(nums, index + 1, high);
		return n;
	}

	/* This is BST but not balanced */

	// public Node sortedArrayToBST(int[] nums) {
	// int size = nums.length;
	// if(size==0) return null;

	// int i = size/2;
	// Node root = new Node(nums[i]);
	// if(i-1 >= 0)
	// root.left = new Node(nums[i-1]);
	// if(i+1 < size)
	// root.right = new Node(nums[i+1]);

	// if(root.left!=null)
	// root.left.left = createNode(nums, i-1-1, false);
	// if(root.right!=null)
	// root.right.right = createNode(nums, i+1+1, true);

	// return root;
	// }

	// private Node createNode(int[] nums, int index, boolean isRightNode){
	// if(index>=nums.length || index<0) return null;
	// Node n = new Node(nums[index]);
	// if(isRightNode){
	// n.right = createNode(nums, index+1, true);
	// }else{
	// n.left = createNode(nums, index-1, false);
	// }
	// return n;
	// }
}