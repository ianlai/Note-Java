import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversalIterative {

	public static void main(String[] args) {
		TreeNode root = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		List list = preorderTraversal(root);
		System.out.println(list);
	}

    public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        
        TreeNode cur = root;
        while(cur!=null){
            l.add(cur.val);
            if(cur.right!=null) s.push(cur.right);
            cur=cur.left;
            if(cur==null && !s.isEmpty())  cur=s.pop();
        }
        return l;
    }
}