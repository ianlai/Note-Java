package tree;

public class _101_SymmetricTree {

	public static void main(String[] args) {
		_101_SymmetricTree obj = new _101_SymmetricTree();
		
		TreeNode tree1 = TreeNode.arrayToTree(new Integer[] { 1, 2, 2, 3, null, null, 3 });  //symmetric
		TreeNode tree2 = TreeNode.arrayToTree(new Integer[] { 1, 2, 3, 3, null, 2, null });  //non-symmetric
		System.out.println(obj.isSymmetric(tree1));
		System.out.println(obj.isSymmetric(tree2));
	}

    public boolean isSymmetric(TreeNode n) {
        if(n==null) return true;
        return helper(n.left, n.right);
    }
    private boolean helper(TreeNode l, TreeNode r){
        if(l==null && r==null) return true;
        if(l==null && r!=null) return false;
        if(l!=null && r==null) return false;
        
        /* Both l!=null and r!=null */
        if(l.val!=r.val) return false;
        if(!helper(l.left, r.right)) return false; //outer
        if(!helper(l.right, r.left)) return false; //inner
        
        return true;
    }
}
