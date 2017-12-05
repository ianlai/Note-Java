package bst;

import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _235_LowestCommonAncestorOfABinarySearchTree {

	public static void main(String[] args) {
		_235_LowestCommonAncestorOfABinarySearchTree obj = new _235_LowestCommonAncestorOfABinarySearchTree();
		TreeNode t1 = TreeNode.arrayToTree(new Integer[]{5,3,8,2,4,6,9});
		
		TreeNode p1 = t1.right.left;
		TreeNode q1 = t1.left.left;
		TreeNode ans1 = obj.lowestCommonAncestor(t1, p1, q1);
		
		TreeNode p2 = t1.right.left;
		TreeNode q2 = t1.right.right;
		TreeNode ans2 = obj.lowestCommonAncestor(t1, p2, q2);
		
		System.out.println(ans1.val);
		System.out.println(ans2.val);
	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if(root==null || p==null || q==null) return null;
        if(p.val < root.val && q.val < root.val ) 
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val ) 
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}