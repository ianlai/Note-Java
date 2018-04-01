package tree;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) 
 * of two given nodes in the tree.
 * Note: We allow a node to be a descendant of itself.
 */
public class _236_LowestCommonAncestorOfABinaryTree {

	public static void main(String[] args) {
		_236_LowestCommonAncestorOfABinaryTree obj = new _236_LowestCommonAncestorOfABinaryTree();
		TreeNode root = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		
		/* LCA = 4 */
		TreeNode p1 = root.left.left.left;
		TreeNode q1 = root.left.left.right;
		TreeNode r1 = obj.lowestCommonAncestor(root, p1, q1);
		System.out.println(r1.val);
		
		/* LCA = 1 */
		TreeNode p2 = root.left.left.left;
		TreeNode q2 = root.right.left;
		TreeNode r2 = obj.lowestCommonAncestor(root, p2, q2);
		System.out.println(r2.val);
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
        /* Either case cannot do more recursive on root. 
         * The recursive will stops when reaching p or q. 
         */
    	if(root==null || root==p || root==q) return root;
        
        TreeNode l = lowestCommonAncestor(root.left , p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        /* p and q are in the two sides (where we try to find) */
        if(l!=null && r!=null) return root;
        
        /* p and q are in the right hand side (or both are null)*/
        if(l==null) return r;
        
        /* p and q are in the left hand side*/
        if(r==null) return l;
        
        return new TreeNode(-1); //never fall to here   
    }
}
