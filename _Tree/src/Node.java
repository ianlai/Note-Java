import java.util.ArrayList;
import java.util.List;

class Node {
	int val;
	String name;
	Node right, left;

	Node() {
	}

	Node(int i) {
		val = i;
		name = String.valueOf(i);
	}

	Node(int i, String n) {
		val = i;
		name = n;
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

	public static Node arrayToTree(Integer[] input) {
		Node root = createNode(input, 1);
		return root;
	}

	private static Node createNode(Integer[] input, int index) {
		if (index <= input.length) {
			Integer v = input[index - 1]; // tree's index starts from 1
			if (v != null) {
				Node t = new Node(v);                       //create node, input value  
				t.left = createNode(input, index * 2);      //connect left node 
				t.right = createNode(input, index * 2 + 1); //connect right node
				return t;
			}
		}
		return null;
	}

	public static boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(Node left, Node right) {
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

	public void printBFS() {
		List<Node> list = new ArrayList<Node>();
		list.add(this);
		while (!list.isEmpty()) {
			Node current = list.remove(0);
			System.out.print(current.val + "-");
			if (current.left != null)
				list.add(current.left);
			if (current.right != null)
				list.add(current.right);
		}
		System.out.println();
	}

	public static void printBFS(Node n) {
		List<Node> list = new ArrayList<Node>();
		list.add(n);
		while (!list.isEmpty()) {
			Node current = list.remove(0);
			System.out.print(current.val + "-");
			if (current.left != null)
				list.add(current.left);
			if (current.right != null)
				list.add(current.right);
		}
	}
	
	
}
