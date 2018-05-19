package tree;

public class Tester {

	public static void main(String[] args) {
		TreeNode t1 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,null,6,null});
		System.out.println(t1.levelOrderWithNull());
		
		TreeNode t2 = TreeNode.arrayToTree(new Integer[]{1,2,3,4,null,6,null,null,9,null,null,12,13});
		System.out.println(t2.levelOrderWithNull());
		
		/*
		      5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
		 */
		/* null should be added to left and right even below a null */
		//TreeNode t3 = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});  //No!
		TreeNode t3 = TreeNode.arrayToTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,null,null,1});    //Correct
		System.out.println(t3.levelOrderWithNull());
	}

}
