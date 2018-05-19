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
		
		/* Path sums: 27, 22, 26, 18 */
		
		/* The way to create a tree is different from leetcode. Do not confuse.*/
		//TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});  //Leetcode
		  TreeNode tree = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,null,null,1});
		
		System.out.println(tree.levelOrder());
		System.out.println(tree.levelOrderWithNull());
		
		int sum = 22;
		System.out.println("target="+sum);
		System.out.println(obj.hasPathSum(tree,sum));	
		System.out.println(obj.hasPathSum1(tree,sum));
		System.out.println();
		
		sum = 17;
		System.out.println("target="+sum);
		System.out.println(obj.hasPathSum(tree,sum));	
		System.out.println(obj.hasPathSum1(tree,sum));
		System.out.println();
		
		sum = 18;
		System.out.println("target="+sum);
		System.out.println(obj.hasPathSum(tree,sum));	
		System.out.println(obj.hasPathSum1(tree,sum));
		System.out.println();
	}
	/*====================================================*/
	/* v2 (concise) */
    public boolean hasPathSum(TreeNode root, int target) {
        if(root==null) return false;
        return helper(root, target, root.val);
    }
    /* We should calculate when coming down to a leaf.
     * Therefore, we use both sub nodes equal to null to complete the recursive instead of n=null.
     */
    public boolean helper(TreeNode n, int target, int cur){
        if(n.left==null && n.right==null){
            return target==cur ? true : false;
        }
        if(n.left!=null  && helper(n.left,  target, cur+n.left.val))  return true;
        if(n.right!=null && helper(n.right, target, cur+n.right.val)) return true;
        return false;
    }
    /*====================================================*/
    /* v1 (previous code) */
    public boolean hasPathSum1(TreeNode root, int target) {
        if(root==null) return false;
        int sum = 0;
        if(helper1(root, sum, target)) return true;
        else return false;
    }
    private boolean helper1(TreeNode n, int sum, int target){
        if(n!=null)
            sum += n.val;
        
        if(n.left==null && n.right==null){    
            if(sum==target) return true;
        }else{
            if(n.left!=null){
                if(helper1(n.left, sum, target)) return true;
            }
            if(n.right!=null){
                if(helper1(n.right, sum, target)) return true;
            }
        }
        return false;
    }
}
