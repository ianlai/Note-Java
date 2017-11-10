package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		List<Integer> list2 = obj.inorderTraversalRecursive(tree);
		System.out.println(list1);
		System.out.println(list2);
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
    
	/* Recursive */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        List<Integer> listLeft = inorderTraversal(root.left);
        if(listLeft!=null) list.addAll(listLeft);
        
        list.add(root.val);
        
        List<Integer> listRight = inorderTraversal(root.right);
        if(listRight!=null) list.addAll(listRight);
        
        return list;
    }
}