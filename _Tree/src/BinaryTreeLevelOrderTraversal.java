import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * Definition for a binary tree node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node(int x) { val = x; }
 * }
 */

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tree = Node.arrayToTree(new Integer[] { 2, 1, 18, null, 14, 3,5, 7,null,8, 5,4,16,null,9 });  
		System.out.println(levelOrder(tree));
	}
    static class TN{
        Node node; 
        int level; 
        TN(Node tn, int l) {node = tn; level = l;}
    }
    public static List<List<Integer>> levelOrder(Node root) {
        if(root==null) return new ArrayList<>();
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        
        Queue<TN> q = new ArrayDeque<TN>();
        q.add(new TN(root, 1));
        
        int currentLevel = 1; 
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){    
            /* poll */
            TN first = q.poll();
            
            /* add children */
            if(first.node.left!=null)
                q.add(new TN(first.node.left, first.level+1));
            if(first.node.right!=null)
                q.add(new TN(first.node.right, first.level+1));
            
            /* use */ 
            if(first.level != currentLevel){
                //System.out.println();
                ll.add(list);
                list = new ArrayList<Integer>();
                
                currentLevel++; 
            }
            list.add(first.node.val);
            //System.out.print(first.node.val + " ");
        }
        ll.add(list);
        return ll; 
    }
}