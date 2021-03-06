package tree;

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _104_MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		_104_MaximumDepthOfBinaryTree obj = new _104_MaximumDepthOfBinaryTree();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,null,1,2,3,4,5,6,7,8,9,null,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1};
		TreeNode tree = TreeNode.arrayToTree(arr);
		List<List<Integer>> ll = tree.levelOrder();
		int d1 = obj.maxDepth(tree);
		int d2 = obj.maxDepth2(tree);
		System.out.println("Depth (method1): " + d1);
		System.out.println("Depth (method2): " + d2);
		System.out.println(ll);
	}
	/* Method1: Recursive (simpler) */
	public int maxDepth(TreeNode n){
		if(n==null) return 0;  
		//if(n.left==null&&n.right==null) return 1;
		int height = Math.max(maxDepth(n.left), maxDepth(n.right));
		return height+1;
	}
	/* Method2: DFS */
    public int maxDepth2(TreeNode root) {
        int[] depth = new int[2];
        depth[0] = 1;   //max depth
        depth[1] = 1;   //current depth
        if(root==null) return 0;
        dfs(root, depth);
        return depth[0];
    }
    void dfs(TreeNode root, int[] d){
        if(root.left==null && root.right==null){
            d[0] = Math.max(d[0], d[1]);
            d[1]--;
            return;
        }
        if(root.left!=null){
            d[1]++;
            dfs(root.left, d);
        }
        if(root.right!=null){
            d[1]++;
            dfs(root.right, d);
        }
        d[1]--;
    } 
}