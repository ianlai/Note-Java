import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	String name;
	TreeNode right, left;

	TreeNode() {
	}

	TreeNode(int i) {
		val = i;
		name = String.valueOf(i);
	}

	TreeNode(int i, String n) {
		val = i;
		name = n;
	}
	
	public static TreeNode getDefaultTree(){
		return arrayToTree(new Integer[]{1,2,3,null,5,6,7, null, null, 10, 11, null, 12, 13, 14, null,null,null,null,20,null,30,40,null,null,50,60});
	}

	public void printPreOrder() {
		System.out.print(val + "-");
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.print(val + "-");
		if (right != null)
			right.printInOrder();
	}

	public void printPostOrder() {
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		System.out.print(val + "-");
	}

	public String inOrder(String string) {
		if (left != null)
			string = left.inOrder(string);
		string += "-" + name;
		if (right != null)
			string = right.inOrder(string);
		return string;
	}

	// NO!!This method corresponding to StringBuilder's one cannot work with
	// String.
	// The reason is that String is immutable.
	// public void inOrder(String ss) {
	// if (left != null)
	// left.inOrder(ss);
	// ss += "-" + name;
	// if (right != null)
	// right.inOrder(ss);
	// //return string.toString();
	// }
	public void inOrder(StringBuilder sb) {
		if (left != null)
			left.inOrder(sb);
		sb.append("-" + name);
		if (right != null)
			right.inOrder(sb);
		// return string.toString();
	}

	public static TreeNode arrayToTree(Integer[] input) {
		TreeNode root = createNode(input, 1);
		return root;
	}

	private static TreeNode createNode(Integer[] input, int index) {
		if (index <= input.length) {
			Integer v = input[index - 1]; // tree's index starts from 1
			if (v != null) {
				TreeNode t = new TreeNode(v);                       //create node, input value  
				t.left = createNode(input, index * 2);      //connect left node 
				t.right = createNode(input, index * 2 + 1); //connect right node
				return t;
			}
		}
		return null;
	}

	public void printBFS() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(this);
		while (!list.isEmpty()) {
			TreeNode current = list.remove(0);
			System.out.print(current.val + "-");
			if (current.left != null)
				list.add(current.left);
			if (current.right != null)
				list.add(current.right);
		}
		System.out.println();
	}

	public static void printBFS(TreeNode n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(n);
		while (!list.isEmpty()) {
			TreeNode current = list.remove(0);
			System.out.print(current.val + "-");
			if (current.left != null)
				list.add(current.left);
			if (current.right != null)
				list.add(current.right);
		}
	}
	
	
}
