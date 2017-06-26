
public class LinkedList {
	
	public ListNode start; 
	public ListNode end;
	LinkedList(){
		start = null;
		end = null;
	}
	public void add(int val){
		ListNode n = new ListNode(val);
		if(start==null){
			start = n;
			end = n;
		}else{
			end.next = n;
			end = end.next;
		}
	}
//	public void print(){
//		ListNode n = start;
//		while(n!=null){
//			System.out.print(n.val + " -> ");
//			n = n.next;
//		}
//		return;
//	}	
}
