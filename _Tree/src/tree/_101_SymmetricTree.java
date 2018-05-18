package tree;

/* 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
   For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
   
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	
	But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
 */
public class _101_SymmetricTree {

	public static void main(String[] args) {
		_101_SymmetricTree obj = new _101_SymmetricTree();
		
		TreeNode tree1 = TreeNode.arrayToTree(new Integer[] { 1, 2, 2, 3, null, null, 3 });  //symmetric
		TreeNode tree2 = TreeNode.arrayToTree(new Integer[] { 1, 2, 3, 3, null, 2, null });  //non-symmetric
		System.out.println(obj.isSymmetric(tree1));
		System.out.println(obj.isSymmetric(tree2));
	}

	/* Recursive */
    public boolean isSymmetric(TreeNode n) {
        if(n==null) return true;
        return helper(n.left, n.right);
    }
    private boolean helper(TreeNode l, TreeNode r){
    	/* Both are null */
        if(l==null && r==null) return true;
        
        /* Either is null */
        if(l==null || r==null) return false;
        
        /* Both are not null */
        
        /* Elements are different */
        if(l.val!=r.val) return false;
        
        /* Outer nodes are different */
        if(!helper(l.left, r.right)) return false; //outer
        
        /* Inner nodes are different */
        if(!helper(l.right, r.left)) return false; //inner
        
        return true;
    }
    /* Iterative */
    
}
