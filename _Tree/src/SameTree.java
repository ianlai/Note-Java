
public class SameTree {

	public static void main(String[] args) {
		
		Node t1 = Node.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		Node t2 = Node.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		Node t3 = Node.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8, null, 9,10,11,12});
		Node t4 = Node.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11});
		Node t5 = Node.arrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13});
		
		System.out.println(isSameTree(t1,t2));
		System.out.println(isSameTree(t1,t3));
		System.out.println(isSameTree(t1,t4));
		System.out.println(isSameTree(t1,t5));
	}

    public static boolean isSameTree(Node p, Node q) {
        if(p==null && q==null) return true; 
        if(p!=null && q==null) return false;
        if(p==null && q!=null) return false;
        return helper(p, q);
    }
    private static boolean helper(Node p, Node q){
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
}
