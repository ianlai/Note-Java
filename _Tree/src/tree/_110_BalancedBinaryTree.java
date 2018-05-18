package tree;
/*
 *  Given a binary tree, determine if it is height-balanced.
	For this problem, a height-balanced binary tree is defined as:
	
	a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	
	Example 1:
	Given the following tree [3,9,20,null,null,15,7]:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Return true.
	
	Example 2:
	Given the following tree [1,2,2,3,3,null,null,4,4]:
	
	       1
	      / \
	     2   2
	    / \
	   3   3
	  / \
	 4   4
	Return false.

 */
public class _110_BalancedBinaryTree {
	public static void main(String[] args) {
		_110_BalancedBinaryTree obj = new _110_BalancedBinaryTree();
		TreeNode t1 = TreeNode.arrayToTree(new Integer[]{3,9,20,null,null,15,7});
		TreeNode t2 = TreeNode.arrayToTree(new Integer[]{1,2,2,3,3,null,null,4,4});
		System.out.println("t1:" + obj.isBalanced(t1));
		System.out.println("t2:" + obj.isBalanced(t2));
	}
    public boolean isBalanced(TreeNode n) {
        if(n==null) return true;
        if(Math.abs(depth(n.left)-depth(n.right))>1) return false;
        return isBalanced(n.left) && isBalanced(n.right);
    }
    public int depth(TreeNode n){
        if(n==null) return 0;
        return Math.max(depth(n.left), depth(n.right))+1;
    }
}