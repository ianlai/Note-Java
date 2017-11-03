package tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class _107_BinaryTreeLevelOrderTraversal2 {

	public static void main(String[] args) {
		_107_BinaryTreeLevelOrderTraversal2 obj = new _107_BinaryTreeLevelOrderTraversal2();
		TreeNode tree = TreeNode.arrayToTree(new Integer[] { 2, 1, 18, null, 14, 3,5, null, null,8, 5,4,16,null,9 });
		List<List<Integer>> ll = obj.levelOrderBottom(tree);
		System.out.println(ll);
	}
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(root==null) return ll;
        
        Queue<TreeNode> curr = new LinkedList<>(); //not Integer, or we will lost the left and right info
        Queue<TreeNode> next = new LinkedList<>(); 
        
        /* Top-down level order traversal */
        curr.add(root);
        while(!curr.isEmpty()){
        	List<Integer> list = new ArrayList<>();
        	while(!curr.isEmpty()){
        		TreeNode n = curr.poll();
        		//System.out.println(n.val);
        		list.add(n.val);        //add to list
        		if(n.left!=null)  next.add(n.left);
        		if(n.right!=null) next.add(n.right);
        	}	
        	ll.add(list);
        	curr = next;  //original curr queue will be GC later
        	next = new LinkedList<>();
        }
        
        /* Reverse the double list */ 
        List<List<Integer>> revlist = new ArrayList<List<Integer>>();
        for(int i=0; i<ll.size();i++){
        	revlist.add(ll.get(ll.size()-1-i));
        }
        
        return revlist;
    }
}
