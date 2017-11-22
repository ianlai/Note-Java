package bst;

import tree.TreeNode;

public class _098_ValidateBinarySearchTree {

	public static void main(String[] args) {
		_098_ValidateBinarySearchTree isvalidbst = new _098_ValidateBinarySearchTree();
		TreeNode tree1 = TreeNode.arrayToTree(new Integer[] { 2, 1, 3, null, 4, null, 7 });  
		TreeNode tree2 = TreeNode.arrayToTree(new Integer[] { 5, 1, 8, null, 3, null, 9 });  
		System.out.println(isvalidbst.isValidBST(tree1));
		System.out.println(isvalidbst.isValidBST(tree2));

	}

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return helper(root, max, min);
    }
    private boolean helper(TreeNode n, int max, int min){
        if(n==null) return true; //no violation, so true
        
        int v = n.val;
        if(v > max || v < min) return false; //violation
        
        /* recursively check */
        if(helper(n.left, v-1, min)==false) return false;
        if(v==min && n.left!=null && n.left.val>=v) return false;
        
        if(helper(n.right, max, v+1)==false) return false;
        if(v==max && n.right!=null && n.right.val<=v) return false;
        return true;
    }
}