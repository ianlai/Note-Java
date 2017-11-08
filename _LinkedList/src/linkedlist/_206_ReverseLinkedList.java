package linkedlist;

public class _206_ReverseLinkedList {

	public static void main(String[] args) {
		_206_ReverseLinkedList obj = new _206_ReverseLinkedList();
		ListNode l1 = ListNode.createListDefault();
		l1.print();
		
		ListNode l2 = obj.reverse(l1);
		l2.print();

	}
	public ListNode reverse(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode p1 = null;
		ListNode p2 = head; 
		ListNode p3 = head.next; 
		while(p2!=null){
			p2.next = p1;
			p1 = p2; 
			p2 = p3;
			if(p3!=null) p3 = p3.next; 
		}
		head = p1; 
		return head;
	}

}
