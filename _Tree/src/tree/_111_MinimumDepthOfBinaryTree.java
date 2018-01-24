package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _111_MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		_111_MinimumDepthOfBinaryTree obj = new _111_MinimumDepthOfBinaryTree();
		TreeNode tree = TreeNode.getDefaultTree();
		int res1 = obj.minDepth(tree);
		int res2 = obj.minDepth2(tree);
		
		tree.printBFS();
		System.out.println(res1);
		System.out.println(res2);
	}
	
	/* Level order traversal, but actually not needed */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int layer=1;
        while(!q1.isEmpty()){
            //System.out.println("layer - " + layer + " " + q1.peek().val);
            while(!q1.isEmpty()){
                TreeNode n = q1.poll();
                if(n.left==null && n.right==null){
                    //System.out.println(n.val);
                    return layer;
                }
                if(n.left !=null) q2.add(n.left);
                if(n.right!=null) q2.add(n.right);
            }
            layer++;
            q1 = q2; 
            q2 = new LinkedList<>();
        }
        return layer;
    }
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left+right+1 : Math.min(left,right)+1;
    }
}