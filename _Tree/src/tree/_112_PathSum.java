package tree;

/* 
   Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
   such that adding up all the values along the path equals the given sum.
   For example: 
   Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class _112_PathSum {

	public static void main(String[] args) {
		_112_PathSum obj = new _112_PathSum();
		
		TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});  
		int sum=22;
		
		System.out.println(obj.hasPathSum(tree,sum));	
	}
    public boolean hasPathSum(TreeNode root, int target) {
        if(root==null) return false;
        int sum = 0;
        if(helper(root, sum, target)) return true;
        else return false;
    }
    private boolean helper(TreeNode n, int sum, int target){
        if(n!=null)
            sum += n.val;
        
        if(n.left==null && n.right==null){    
            if(sum==target) return true;
        }else{
            if(n.left!=null){
                if(helper(n.left, sum, target)) return true;
            }
            if(n.right!=null){
                if(helper(n.right, sum, target)) return true;
            }
        }
        return false;
    }
}
