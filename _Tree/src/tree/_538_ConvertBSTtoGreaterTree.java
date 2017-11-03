package tree;

public class _538_ConvertBSTtoGreaterTree {

	public static void main(String[] args) {
		_538_ConvertBSTtoGreaterTree obj = new _538_ConvertBSTtoGreaterTree();
		TreeNode tree = TreeNode.arrayToTree(new Integer[]{11,2,29,1,7,15,40,null,null,null,null,null,null,35});
		tree.printBFS();
		
		//obj.addOne(tree);
		//tree.printBFS();
		
		obj.convertBST(tree);
		tree.printBFS();
	}
	public void addOne(TreeNode n){
		if(n.left!=null)
			addOne(n.left);
		n.val = n.val + 1;
		if(n.right!=null)
			addOne(n.right);
	}
    public TreeNode convertBST(TreeNode root) {
    	if(root==null) return root;
    	
    	int[] sum = new int[1];  //using int[] to keep tracking the sum 
    	//int sum = 0;           //using int variable will NOT work
     	helper(root, sum);
    	return root;
    }
    private void helper(TreeNode n, int[] sum){
    	if(n.right!=null) 
    		helper(n.right, sum);
    	
    	/*Not including the original key*/
    	//int temp = n.val; 
    	//n.val = sum[0];
    	//sum[0] += temp;
    	
    	/*Including the original key*/
    	sum[0] += n.val;
        n.val = sum[0];
        
    	if(n.left!=null) 
    		helper(n.left, sum);
    }
}
