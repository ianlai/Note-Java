package bst;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/* Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class _173_BinarySearchTreeIterator {

	public static void main(String[] args) {
		TreeNode tree = TreeNode.arrayToTree(new Integer[]{15,7,38,5,9,22,57,3,6,8,13});
		BSTIterator itr = new BSTIterator(tree);
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
class BSTIterator {

    List<TreeNode> list = new ArrayList<>();
    int length = 0;
    int cur = 0;
    public BSTIterator(TreeNode root) {
        inorderTraverse(root);
        length = list.size();
    }
    public void inorderTraverse(TreeNode n){
        if(n==null) return;
        inorderTraverse(n.left);
        list.add(n);
        inorderTraverse(n.right);
        return;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur<length) ? true : false;
    }

    /** @return the next smallest number */
    public int next() {
        cur++;
        return list.get(cur-1).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
