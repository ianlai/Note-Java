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
		TreeNode t3 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		
		System.out.println("Top-Down:");
		System.out.println("t1:" + obj.isBalanced(t1));
		System.out.println("t2:" + obj.isBalanced(t2));
		System.out.println("t3:" + obj.isBalanced(t3));
		
		System.out.println();
		System.out.println("Buttom-Up:");
		System.out.println("t1:" + obj.isBalancedButtom(t1));
		System.out.println("t2:" + obj.isBalancedButtom(t2));
		System.out.println("t3:" + obj.isBalancedButtom(t3));
	}
	/* ========================================= */
	/* Buttom-up (85%, faster, O(n)) 
	 * isBalanced does not need to be called recursively.
	 * Only depth needs to be called for all nodes -> O(n) */
	public boolean isBalancedButtom(TreeNode root) {
	    if(root==null) return true;
	    return depthButtom(root)!=-1;
	}
	public int depthButtom(TreeNode node){
	    if(node==null){
	        return 0;
	    }
	    int lH=depthButtom(node.left);
	    if(lH==-1) return -1;
	    int rH=depthButtom(node.right);
	    if(rH==-1) return -1;
	    
	    if(lH-rH<-1 || lH-rH>1){
	        return -1;
	    }else{
	    	return Math.max(lH,rH)+1;
	    }
	}
	/* ========================================= */
	/* Top-down (34%, slower)
	 * Both isBalanced and depth need to be called recursively.
	 * Time complexity: 
	 * 	1       isBalanced -> n
	 *  2,3     isBalanced -> n/2, n/2
	 *  4,5,6,7 isBalanced -> n/4, n/4, n/4, n/4
	 *  Summarize all of them -> n + n + n + ... (logn terms) = O(nlogn) 
	 *  Note: Most discussions in leetcode say this is a O(n2) approach. Not sure which one is correct.
	 */
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