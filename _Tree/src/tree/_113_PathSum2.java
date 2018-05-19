package tree;
import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 */
public class _113_PathSum2 {

	public static void main(String[] args) {
		_113_PathSum2 obj = new _113_PathSum2();
		
		//TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1});         //Leetcode 
		TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,null,5,1}); //My constructor

		tree.printBFS();
		int sum=22;
		
		List<List<Integer>> ll = obj.pathSum(tree, sum);	
		System.out.println(ll);
	}
    public List<List<Integer>> pathSum(TreeNode root, int target) {
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();  	
        if(root==null) return ll;
        
        int sum = 0;
        List<Integer> cur = new ArrayList<Integer>();
        helper(root, sum, target, ll, cur);
        return ll;
    }
    private void helper(TreeNode n, int sum, int target, List<List<Integer>> ll, List<Integer> cur){
    	//System.out.println("> " + cur + "  " + n.val);
        if(n!=null){
            sum += n.val;
            cur.add(n.val);
        }
        if(n.left==null && n.right==null){    
            if(sum==target){
            	//System.out.println(">>>> " + cur);
            	ll.add(new ArrayList<Integer>(cur));  //MUST
            }
        }else{
            if(n.left!=null){
                helper(n.left, sum, target,ll, cur);
                cur.remove(cur.size()-1);  //remove the last one
            }
            if(n.right!=null){
            	helper(n.right, sum, target,ll, cur);
            	cur.remove(cur.size()-1);  //remove the last one
            }
        }
    }
}
