package traversal;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

import tree.TreeNode;

import java.util.ArrayDeque;

/**
 * Definition for a binary tree TreeNode.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class _102_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = TreeNode.arrayToTree(new Integer[] { 2, 1, 18, null, 14, 3,5, null ,null,8, 5,4,16,null,9 });  
		System.out.println(levelOrder(tree));
	}
    static class TN{
        TreeNode TreeNode; 
        int level; 
        TN(TreeNode tn, int l) {TreeNode = tn; level = l;}
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        
        Queue<TN> q = new ArrayDeque<TN>();
        q.add(new TN(root, 1));
        
        int currentLevel = 1; 
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){    
            /* poll */
            TN first = q.poll();
            
            /* add children */
            if(first.TreeNode.left!=null)
                q.add(new TN(first.TreeNode.left, first.level+1));
            if(first.TreeNode.right!=null)
                q.add(new TN(first.TreeNode.right, first.level+1));
            
            /* use */ 
            if(first.level != currentLevel){
                //System.out.println();
                ll.add(list);
                list = new ArrayList<Integer>();
                
                currentLevel++; 
            }
            list.add(first.TreeNode.val);
            //System.out.print(first.TreeNode.val + " ");
        }
        ll.add(list);
        return ll; 
    }
}