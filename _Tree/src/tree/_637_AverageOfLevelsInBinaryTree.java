package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class _637_AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {
		_637_AverageOfLevelsInBinaryTree obj = new _637_AverageOfLevelsInBinaryTree();
		TreeNode tree = TreeNode.getDefaultTree();
		List<Double> list = obj.averageOfLevels(tree);
		
		tree.printBFS();
		System.out.println(list);
	}

	class TN {
		int l; // level
		TreeNode n; // node

		TN(int l, TreeNode n) {
			this.l = l;
			this.n = n;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Queue<TN> queue = new LinkedList<>();
		queue.add(new TN(1, root));
		int level = 1;
		double avg = 0;
		int num = 0;

		while (!queue.isEmpty()) {
			TN tn = queue.poll();
			if (tn.n.left != null) {
				queue.add(new TN(tn.l + 1, tn.n.left));
			}
			if (tn.n.right != null) {
				queue.add(new TN(tn.l + 1, tn.n.right));
			}

			if (tn.l != level) { // go one layer deeper already
				ans.add(avg);
				avg = 0;
				num = 0;
				level++;
			}
			avg = (avg * num + tn.n.val) / (num + 1);
			num++;
		}
		ans.add(avg);
		return ans;
	}
}