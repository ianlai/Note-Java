import java.util.List;
import java.util.ArrayList;

public class _95_UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		_95_UniqueBinarySearchTrees2 obj = new _95_UniqueBinarySearchTrees2();
		List<TreeNode> list = obj.generateTrees(3);
		for(TreeNode n: list){
			n.printBFS();
		}
		System.out.println("Num of trees: " + list.size());
		System.out.println("--END--");
	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ans = new ArrayList<>();
		if (n == 0)
			return ans;

		ans = helper(1, n);
		return ans;
	}

	/* return a list of tree that has the range between m and n */
	private List<TreeNode> helper(int m, int n) {
		//System.out.println("== " + m + " " + n + "== ");
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (m > n) {
			/* MUST add null 
			 * Cannot do nothing because foreach loop cannot find it if nothing inside 
			 */
			result.add(null);
		} else if (m == n) {
			TreeNode node = new TreeNode(m);
			result.add(node);
		} else {
			for (int i = m; i <= n; i++) {
				//System.out.println("m, n, i : " + m + " " + n + " - " + i);
				List<TreeNode> ls = helper(m, i - 1);
				List<TreeNode> rs = helper(i + 1, n);
				
				for(TreeNode l: ls){
					for(TreeNode r: rs){
						TreeNode node = new TreeNode(i);
						node.left =l;
						node.right=r;
						result.add(node);
						//System.out.println(">>>>>>>");
						node.printBFS();
					}
				}	
			}
		}
		return result;
	}
}
