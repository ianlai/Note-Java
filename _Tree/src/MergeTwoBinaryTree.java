public class MergeTwoBinaryTree {

	public static void main(String[] args) {
		Node tree1 = Node.arrayToTree(new Integer[] { 1, 3, 2, 5 });  
		Node tree2 = Node.arrayToTree(new Integer[] { 2, 1, 3, null, 4, null, 7 });  
		tree1.printBFS();
		tree2.printBFS();
		Node treeMerge = mergeTrees(tree1, tree2);
		treeMerge.printBFS();
	}
    public static Node mergeTrees(Node t1, Node t2) {
        if(t1==null && t2==null) return null;
        if(t1!=null && t2==null) return t1;
        if(t1==null && t2!=null) return t2;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        return t1;
    }
}