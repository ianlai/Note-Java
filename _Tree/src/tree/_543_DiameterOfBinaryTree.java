package tree;

public class _543_DiameterOfBinaryTree {

	public static void main(String[] args) {
		_543_DiameterOfBinaryTree obj = new _543_DiameterOfBinaryTree();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,null,1,2,3,4,5,6,7,8,9,null,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1};
		TreeNode tree = TreeNode.arrayToTree(arr);
		System.out.println(obj.diameterOfBinaryTree(tree));
	}
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int heightSum = height(root.left) + height(root.right);   //max diameter through node
        int maxLeftDiameter  = diameterOfBinaryTree(root.left);   //max diameter does not throught node neighther right
        int maxRightDiameter = diameterOfBinaryTree(root.right);  //max diameter does not throught node neighther left
        return Math.max(heightSum, Math.max(maxLeftDiameter, maxRightDiameter));
    }
    public int height(TreeNode n){
        if(n==null) return 0;
        else{
            int h = Math.max(height(n.left), height(n.right));
            return h+1;
        }
    }
}