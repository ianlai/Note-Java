package tree;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class _199_BinaryTreeRightSideView {

	public static void main(String[] args) {
		_199_BinaryTreeRightSideView obj = new _199_BinaryTreeRightSideView();
		TreeNode tree = TreeNode.arrayToTree(new Integer[] { 2, 1, 18, null, 14, 3, null, null, null, 5, 7});
		tree.printBFS();
		System.out.println(obj.rightSideView(tree));
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root==null) return list;
		
		Queue<TreeNode> curr = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		curr.add(root);
		while(!curr.isEmpty()){
			while(!curr.isEmpty()){
				TreeNode n = curr.poll();
				if(curr.isEmpty()) list.add(n.val);
				if(n.left!=null)  next.add(n.left);
				if(n.right!=null) next.add(n.right);
			}
			curr = next;
			next = new LinkedList<>();
		}
		return list;
	}
}
