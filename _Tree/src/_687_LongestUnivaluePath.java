//  https://leetcode.com/problems/longest-univalue-path/description/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class _687_LongestUnivaluePath {

	public static void main(String[] args) {
		_687_LongestUnivaluePath obj = new _687_LongestUnivaluePath();
		//TreeNode root = TreeNode.arrayToTree(new Integer[]{1,4,5,4,4,5});
		//TreeNode root = TreeNode.arrayToTree(new Integer[]{1,2,2,2,2,2});
		//TreeNode root = TreeNode.arrayToTree(new Integer[]{2,2,1,2,2});
		//TreeNode root = TreeNode.arrayToTree(new Integer[]{1,1});
		
		TreeNode root = TreeNode.arrayToTree(new Integer[] {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2});
		
		System.out.println("ANSWER: " + obj.longestUnivaluePath(root));
	}

    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    private int helper(TreeNode n, int[] res){
        int l = 0;
        int r = 0;
        int sumleft = 0;
		int sumright = 0;
		if (n.left != null) {
			l = helper(n.left, res);
			if (n.val == n.left.val)
				sumleft = l + 1;
		}
		if (n.right != null) {
			r = helper(n.right, res);
			if (n.val == n.right.val)
				sumright = r + 1;
		}
		res[0] = Math.max(res[0], sumright + sumleft);
        System.out.println(n.val + ":" + res[0] + " " + sumleft + " " + sumright);
		return Math.max(sumright, sumleft);
    }

}