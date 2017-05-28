public class Main {

	public static void main(String[] args) {
		Node root = new Node(7);
		root.left = new Node(3);
		root.right = new Node(9);
		root.left.left = new Node(1);
		root.left.right = new Node(5);
		root.left.right.left = new Node(4);
		
		
		
		root.inOrder();
		

		String result1 = root.inOrder("Str: ");
		
		StringBuilder sb = new StringBuilder("Sb:  ");
		root.inOrderSB(sb);
		
		System.out.println();
		System.out.println(result1);
		System.out.println(sb.toString());
	}
	

}
