import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {

	public static void main(String[] args) {
		//TreeNode tree = TreeNode.arrayToTree(new Integer[]{1,2,3,null,5,6,7, null, null, 10, 11, null, 12});
		TreeNode tree = TreeNode.arrayToTree(new Integer[]{1,2,3,null,5,6,7, null, null, 10, 11, null, 12, 13, 14, null,null,null,null,20,null,30,40,null,null,50,60});
		
		System.out.println("------------ Recursively ------------");
		
		System.out.println("Levelorder:");
		tree.printBFS();
		
		System.out.println("Preorder:");
		tree.printPreOrder();
		
		System.out.println("\nInorder:");
		tree.printInOrder();
		
		System.out.println("\nPostorder:");
		tree.printPostOrder();
		
		System.out.println("\n------------ Iteratively (Stack) ------------");
	
		System.out.println("Preorder:");
		List list1 = preorder(tree);
		System.out.println(list1);
		
		System.out.println("Inorder:");
		List list2 = inorder(tree);
		System.out.println(list2);
		
		System.out.println("Postorder:");
		List list3 = postorder(tree);
		System.out.println(list3);
		
		System.out.println("End");
	}

    public static List<Integer> preorder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        
        TreeNode cur = root;
        while(cur!=null){
            l.add(cur.val);                          //use current (1)
            if(cur.right!=null) s.push(cur.right);   //save right (3)
            cur=cur.left;                            //go to left (2)
            if(cur==null && !s.isEmpty())  cur=s.pop();  //because we have this, while loop out only when "null & empty"
        }
        return l;
    }
    
    public static List<Integer> inorder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        
        TreeNode cur = root;
        while(cur!=null || !s.isEmpty()){   //out when "null && empty"
        	if(cur!=null){
        		s.push(cur);      //store cur
        		cur = cur.left;   //go left 
        	}else{                //when reaching the end 
        		cur=s.pop();      
        		l.add(cur.val);   //use pop (one above) 
        		cur=cur.right;    //go right 
        	}
        }
        return l;
    }
    
    public static List<Integer> postorder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if(root==null) return l;
        
        s.push(root);
        while(!s.isEmpty()){
        	TreeNode cur = s.peek();    //test
        	
        	if(cur.left==null && cur.right==null){  
        		s.pop();                //really remove 
        		l.add(cur.val);         
        	}else{                
        		if(cur.right!=null){
        			s.push(cur.right);
        			cur.right = null;   //important! It will become a loop if not adding this line
        		}
        		if(cur.left!=null){
        			s.push(cur.left);
        			cur.left = null;    //important! It will become a loop if not adding this line
        		}
        	}
        }
        return l;
    }
}