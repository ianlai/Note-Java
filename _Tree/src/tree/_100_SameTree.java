package tree;

public class _100_SameTree {

	public static void main(String[] args) {
		_100_SameTree obj = new _100_SameTree();
		
		TreeNode t1 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		TreeNode t2 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		TreeNode t3 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8, null, 9,10,11,12});
		TreeNode t4 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11});
		TreeNode t5 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13});
		
		System.out.println(obj.isSameTree(t1,t2));
		System.out.println(obj.isSameTree(t1,t3));
		System.out.println(obj.isSameTree(t1,t4));
		System.out.println(obj.isSameTree(t1,t5));
	}

	/* 1st time wrote (ugly)*/
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true; 
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        return helper(p, q);
    }
    private boolean helper(TreeNode p, TreeNode q){
        if(p.val!=q.val) return false;
        //left
        if(p.left!=null && q.left!=null){
           if(!helper(p.left, q.left)) return false;
        }else if((p.left==null && q.left!=null) || (p.left!=null && q.left==null)){
            return false;
        }
        //right
        if(p.right!=null && q.right!=null){
           if(!helper(p.right, q.right)) return false;
        }else if((p.right==null && q.right!=null) || (p.right!=null && q.right==null)){
            return false;
        }
        return true;
    }
    
    /* 2nd time write (better)*/ 
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Someone has null
        if(p==null && q==null) return true;  //both null
        if(p==null || q==null) return false; //only one null
        
        //None has null
        if(p.val!=q.val) return false;
        if(!isSameTree(p.left, q.left)) return false;
        if(!isSameTree(p.right, q.right)) return false;
        
        //Finally pass
        return true;
    }
}
