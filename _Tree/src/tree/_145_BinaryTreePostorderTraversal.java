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

// Do it iteratively. 

public class _145_BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		_145_BinaryTreePostorderTraversal obj = new _145_BinaryTreePostorderTraversal();
		TreeNode tree = TreeNode.getDefaultTree();
		List<Integer> list = obj.postorderTraversal(tree);
		System.out.println(list);

	}
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        
        s.push(root);
        while(!s.isEmpty()){
        	TreeNode cur = s.peek();    //test
        	
        	if(cur.left==null && cur.right==null){  
        		s.pop();                //really remove 
        		l.add(cur.val);         
        	}else{                
        		if(cur.right!=null){
        			s.push(cur.right);
        			cur.right = null;   //important! It will become a loop if not adding this line
        		}
        		if(cur.left!=null){
        			s.push(cur.left);
        			cur.left = null;    //important! It will become a loop if not adding this line
        		}
        	}
        }
        return l;
    }
}