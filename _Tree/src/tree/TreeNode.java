package tree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import tree._102_BinaryTreeLevelOrderTraversal.TN;

class TreeNode {
	int val;
	String name;
	TreeNode right, left;

	TreeNode() {
	}

	TreeNode(int i) {
		val = i;
		name = String.valueOf(i);
	}

	TreeNode(int i, String n) {
		val = i;
		name = n;
	}
	
	public static TreeNode getDefaultTree(){
		return arrayToTree(new Integer[]{1,2,3,null,5,6,7, null, null, 10, 11, null, 12, 13, 14, null,null,null,null,20,null,30,40,null,null,50,60});
	}
	public static TreeNode getDefaultTree(int i){
		if(i==0)
			return getDefaultTree();
		else if(i==1)
			return arrayToTree(new Integer[] { 2, 1, 18, null, 14, 3,5, null, null,8, 5,4,16,null,9 });
		else
			return getDefaultTree();
	}
	public static TreeNode getBST(){
		return arrayToTree(new Integer[]{20, 10, 50, 4, 16, 30, 75, 2, 5, 13, 19, 25, null, 60, 90, null, null, null, 7});
	}
	public void printPreOrder() {
		System.out.print(val + "-");
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.print(val + "-");
		if (right != null)
			right.printInOrder();
	}

	public void printPostOrder() {
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		System.out.print(val + "-");
	}

	public String inOrder(String string) {
		if (left != null)
			string = left.inOrder(string);
		string += "-" + name;
		if (right != null)
			string = right.inOrder(string);
		return string;
	}

	// NO!!This method corresponding to StringBuilder's one cannot work with
	// String.
	// The reason is that String is immutable.
	// public void inOrder(String ss) {
	// if (left != null)
	// left.inOrder(ss);
	// ss += "-" + name;
	// if (right != null)
	// right.inOrder(ss);
	// //return string.toString();
	// }
	public void inOrder(StringBuilder sb) {
		if (left != null)
			left.inOrder(sb);
		sb.append("-" + name);
		if (right != null)
			right.inOrder(sb);
		// return string.toString();
	}

	public static TreeNode arrayToTree(Integer[] input) {
		TreeNode root = createNode(input, 1);
		return root;
	}

	private static TreeNode createNode(Integer[] input, int index) {
		if (index <= input.length) {
			Integer v = input[index - 1]; // tree's index starts from 1
			if (v != null) {
				TreeNode t = new TreeNode(v);                       //create node, input value  
				t.left = createNode(input, index * 2);      //connect left node 
				t.right = createNode(input, index * 2 + 1); //connect right node
				return t;
			}
		}
		return null;
	}

	public void printBFS() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(this);
		while (!list.isEmpty()) {
			TreeNode current = list.remove(0);
			System.out.print(current.val + "-");
			if (current.left != null)
				list.add(current.left);
			if (current.right != null)
				list.add(current.right);
		}
		System.out.println();
	}

	public static void printBFS(TreeNode n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(n);
		while (!list.isEmpty()) {
			TreeNode current = list.remove(0);
			System.out.print(current.val + "-");
			if (current.left != null)
				list.add(current.left);
			if (current.right != null)
				list.add(current.right);
		}
	}
	
    static class TN{
        TreeNode TreeNode; 
        int level; 
        TN(TreeNode tn, int l) {TreeNode = tn; level = l;}
    }
    public List<List<Integer>> levelOrder() {
        if(this==null) return new ArrayList<>();
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        
        Queue<TN> q = new ArrayDeque<TN>();
        q.add(new TN(this, 1));
        
        int currentLevel = 1; 
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){    
            /* poll */
            TN first = q.poll();
            
            /* add children */
            if(first.TreeNode.left!=null)
                q.add(new TN(first.TreeNode.left, first.level+1));
            if(first.TreeNode.right!=null)
                q.add(new TN(first.TreeNode.right, first.level+1));
            
            /* use */ 
            if(first.level != currentLevel){
                //System.out.println();
                ll.add(list);
                list = new ArrayList<Integer>();
                
                currentLevel++; 
            }
            list.add(first.TreeNode.val);
            //System.out.print(first.TreeNode.val + " ");
        }
        ll.add(list);
        return ll; 
    }
	
	
}
