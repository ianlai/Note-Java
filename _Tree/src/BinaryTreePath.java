import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePath btp = new BinaryTreePath();
		Node tree1 = Node.arrayToTree(new Integer[] { 1, 3, 2, 5 });  
		Node tree2 = Node.arrayToTree(new Integer[] { 2, 1, 3, null, 4, 3,5, 7,null,null,9 });  
		Node tree3 = Node.arrayToTree(new Integer[] { 2, 1, 239, null, 14, 3,5, 7,null,null,9 });  
		
		System.out.println(btp.binaryTreePaths1(tree1));
		System.out.println(btp.binaryTreePaths2(tree1));
		System.out.println(btp.binaryTreePaths3(tree1));  
		
		System.out.println(btp.binaryTreePaths1(tree2));
		System.out.println(btp.binaryTreePaths2(tree2));
		System.out.println(btp.binaryTreePaths3(tree2));
		
		System.out.println(btp.binaryTreePaths1(tree3));
		System.out.println(btp.binaryTreePaths2(tree3));
		System.out.println(btp.binaryTreePaths3(tree3)); //<--this is wrong 
			
	}

	/* Use List<Node> to store a single path (slow) */
	public List<String> binaryTreePaths1(Node t) {
		List<String> list = new ArrayList<>();
		List<List<Node>> plist = new ArrayList<List<Node>>();
		List<Node> path = new ArrayList<Node>();
		if (t == null)
			return list;

		path.add(t); // root

		if (t.left != null)
			helper1(t.left, path, plist);
		if (t.right != null)
			helper1(t.right, path, plist);
		if (t.left == null && t.right == null) {
			plist.add(path); // special case: only root element
		}

		/* Scan and put the path arrays into the string arrays */
		for (List<Node> p : plist) {
			StringBuilder sb = new StringBuilder();
			for (Node Node : p) {
				sb.append(Node.val + "->");
			}
			sb.setLength(sb.length() - 2); // delete the last "->"
			list.add(sb.toString());
		}
		//System.out.println(list);
		return list;
	}

	private void helper1(Node t, List<Node> p, List<List<Node>> plist) {
		p.add(t);
		if (t.left == null && t.right == null) {
			plist.add(new ArrayList<Node>(p));
			p.remove(p.size() - 1);
			return;
		}
		if (t.left != null)
			helper1(t.left, p, plist);
		if (t.right != null)
			helper1(t.right, p, plist);
		p.remove(p.size() - 1);
		return;
	}

	/* Use String to store (immutable property) */
	public List<String> binaryTreePaths2(Node t) {
		List<String> list = new ArrayList<>();

		if (t == null)
			return list;
		// StringBuilder sb = new StringBuilder();
		String s = new String();
		s = String.valueOf(t.val);

		if (t.left == null && t.right == null) {
			list.add(s);
		}
		if (t.left != null)
			helper2(t.left, s, list);
		if (t.right != null)
			helper2(t.right, s, list);
		return list;
	}

	private void helper2(Node t, String s, List<String> l) {
		s = s + "->" + t.val;
		if (t.left == null && t.right == null) {
			l.add(s);
			// sb.setLength(sb.length()-3);
			return;
		}
		if (t.left != null)
			helper2(t.left, s, l);
		if (t.right != null)
			helper2(t.right, s, l);
		// sb.setLength(sb.length()-3);
		return;
	}

	/* Use StringBuilder to store. 
	 * This needs to worry about how to revert a node when jumping out of a function.
	 * I currently use sb.setLength(sb.length() - 3) to delete the last 3 chars 
	 * but it only works when the value is a single digit. 
	 * So, this one is WRONG answer currently. */
	public List<String> binaryTreePaths3(Node t) {
		List<String> list = new ArrayList<>();

		if (t == null)
			return list;
		StringBuilder sb = new StringBuilder();
		sb.append(t.val);

		if (t.left == null && t.right == null) {
			list.add(sb.toString());
		}
		if (t.left != null)
			helper3(t.left, sb, list);
		if (t.right != null)
			helper3(t.right, sb, list);
		return list;
	}

	private void helper3(Node t, StringBuilder sb, List<String> l) {
		sb.append("->" + t.val);
		if (t.left == null && t.right == null) {
			l.add(sb.toString());
			sb.setLength(sb.length() - 3);
			return;
		}
		if (t.left != null)
			helper3(t.left, sb, l);
		if (t.right != null)
			helper3(t.right, sb, l);
		sb.setLength(sb.length() - 3);
		return;
	}
}