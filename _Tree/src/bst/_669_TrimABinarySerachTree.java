package bst;
// Level: Easy
// Like : 185/42

import tree.TreeNode;

public class _669_TrimABinarySerachTree {

	public static void main(String[] args) {
		_669_TrimABinarySerachTree obj = new _669_TrimABinarySerachTree();
		TreeNode root = TreeNode.arrayToTree(new Integer[]{7,4,12,2,5,8,15,1,3,null,6,null,null,14,23,null,null,null,null,null,null,null,null,null,null,null,null,null,20});
		root.printBFS();
		TreeNode res = obj.trimBST(root, 8, 14);
		res.printBFS();
	}
	
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) return root;
        
        if(root.val>R){
            return trimBST(root.left, L, R);
        }else if(root.val<L){
            return trimBST(root.right, L, R);     
        }else{
            root.left  = trimBST(root.left, L, R); 
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }   
}
