import java.util.ArrayList;
import java.util.List;

public class _113_PathSum2 {

	public static void main(String[] args) {
		_113_PathSum2 obj = new _113_PathSum2();
		
		//TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1});    //Leetcode 
		TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,null,5,1});      //Mine constructor
		//TreeNode tree = TreeNode.arrayToTree(new Integer[] {1,1,1,1,1,1,1});  
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
