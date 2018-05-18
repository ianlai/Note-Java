package traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

// Do it iteratively. 

public class _144_BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		_144_BinaryTreePreorderTraversal obj = new _144_BinaryTreePreorderTraversal();
		TreeNode tree = TreeNode.getDefaultTree();
		List<Integer> list1 = obj.preorderTraversal(tree);
		List<Integer> list2 = obj.preorderTraversalRecursive(tree);
		System.out.println(list1);
		System.out.println(list2);
	}
    //====================================================
	/* Iteratively */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        TreeNode cur = root;
        while(cur!=null){
            l.add(cur.val);
            if(cur.right!=null) s.push(cur.right);
            cur=cur.left;
            if(cur==null && !s.isEmpty())  cur=s.pop();
        }
        return l;
    }
    //====================================================
    /* Recursively */
    List<Integer> mList = new ArrayList<>();
    public List<Integer> preorderTraversalRecursive(TreeNode n){
    	if(n==null) return null;
    	mList.add(n.val);
    	preorderTraversalRecursive(n.left);
    	preorderTraversalRecursive(n.right);
    	return mList;
    }
}