class Node {
	int id;
	String name;
	Node right, left;

	Node(int i) {
		id = i;
		name = String.valueOf(i);
	}

	Node(int i, String n) {
		id = i;
		name = n;
	}

	public void inOrder() {
		if (left != null)
			left.inOrder();
		System.out.print(id + " ");
		if (right != null)
			right.inOrder();
	}

	public String inOrder(String string) {
		if (left != null)
			string = left.inOrder(string);
		string += "-" + name;
		if (right != null)
			string = right.inOrder(string);
		return string;
	}
	public void inOrderSB(StringBuilder string) {
		if (left != null)
			left.inOrderSB(string);
		string.append("-" + name);
		if (right != null)
			right.inOrderSB(string);
		//return string.toString();
	}
}
