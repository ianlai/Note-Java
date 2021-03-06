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

// Note: Recursive solution is trivial, could you do it iteratively?


public class _094_BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		_094_BinaryTreeInorderTraversal obj = new _094_BinaryTreeInorderTraversal();
		TreeNode tree = TreeNode.getDefaultTree();
		List<Integer> list1 = obj.inorderTraversal(tree);
		List<Integer> list2 = obj.inorderTraversalRecursive1(tree);
		List<Integer> list3 = obj.inorderTraversalRecursive2(tree);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}
	
	/* Iteratively */
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        
        TreeNode cur = root;
        while(cur!=null || !s.isEmpty()){   //out when "null && empty"
        	if(cur!=null){
        		s.push(cur);      //store cur
        		cur = cur.left;   //go left 
        	}else{                //when reaching the end 
        		cur=s.pop();      
        		l.add(cur.val);   //use pop (one above) 
        		cur=cur.right;    //go right 
        	}
        }
        return l;
    }
    
	/* Recursive (list defined inside) */
    public List<Integer> inorderTraversalRecursive1(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        List<Integer> listLeft = inorderTraversalRecursive1(root.left);
        if(listLeft!=null) list.addAll(listLeft);
        
        list.add(root.val);
        
        List<Integer> listRight = inorderTraversalRecursive1(root.right);
        if(listRight!=null) list.addAll(listRight);
        
        return list;
    }
    
	/* Recursive (list defined outside) */
    List<Integer> mList = new ArrayList<Integer>();
    public List<Integer> inorderTraversalRecursive2(TreeNode root) {
        if(root==null) return null;        
        inorderTraversalRecursive2(root.left);
        mList.add(root.val);
        inorderTraversalRecursive2(root.right);        
        return mList;
    }
}