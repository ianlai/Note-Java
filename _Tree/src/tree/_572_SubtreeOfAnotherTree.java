package tree;

import java.util.ArrayList;
import java.util.List;

/* 
 * Given two non-empty binary trees s and t, check whether tree t has 
 * exactly the same structure and node values with a subtree of s. 
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.
 */
public class _572_SubtreeOfAnotherTree {

	public static void main(String[] args) {
		_572_SubtreeOfAnotherTree obj = new _572_SubtreeOfAnotherTree();
		
		TreeNode s1 = TreeNode.arrayToTree(new Integer[]{3,4,5,1,2});
		TreeNode t1 = TreeNode.arrayToTree(new Integer[]{4,1,2});

		TreeNode s2 = TreeNode.arrayToTree(new Integer[]{3,4,5,1,2,null,null,null,null,0});
		TreeNode t2 = TreeNode.arrayToTree(new Integer[]{4,1,2});
		
		System.out.println(obj.isSubtree1(s1, t1));  //true
		System.out.println(obj.isSubtree2(s1, t1));  //true
		
		System.out.println(obj.isSubtree1(s2, t2));  //false
		System.out.println(obj.isSubtree2(s2, t2));  //false
	}

	//========== 4.52% ; 53ms (slow) ==========
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        List<TreeNode> nodelist = new ArrayList<>();
        getNodeList(s, t, nodelist);

        for(TreeNode n: nodelist){
            //System.out.println(n.val);
            if(isSame(n, t)) return true;
        }
        return false;
    }
    public void getNodeList(TreeNode s, TreeNode t, List<TreeNode> nodelist){
        if(s==null) return;
        if(s.val==t.val) nodelist.add(s);
        getNodeList(s.left,  t, nodelist);
        getNodeList(s.right, t, nodelist);
    }
    
    //==========  30.89% ; 29ms (faster) ==========
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if(s==null && t!=null) return false;
        if(s==null && t==null) return true;
        return isSame(s,t)||isSubtree2(s.left,t)||isSubtree2(s.right,t);
    }
    
    //========== Common Function ==========
    
    public boolean isSame(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val) return false;
        if(!isSame(s.left,  t.left )) return false;
        if(!isSame(s.right, t.right)) return false;
        return true; 
    }
}