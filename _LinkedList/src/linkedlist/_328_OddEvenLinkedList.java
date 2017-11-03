package linkedlist;

public class _328_OddEvenLinkedList {
	
	public static void main(String[] args) {
		_328_OddEvenLinkedList s = new _328_OddEvenLinkedList();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		n8.next=n9;
		ListNode head = n1;
		//s.traverse(head);
		//s.swap(2, 6, head);
		//s.traverse(head);
		s.oddEvenList(head);
		s.traverse(head);
		
	}

    public ListNode oddEvenList(ListNode head) {
    	ListNode odd = head;
    	ListNode even = head.next;
    	ListNode evenHead = head.next;
    	
    	while(true){
    		odd.next = even.next;
    		if(even.next==null)
    			break;
    		odd = odd.next;
    		even.next = odd.next;
    		if(odd.next==null)
    			break;
    		even = even.next;
    	}
    	odd.next = evenHead; 
		return head;
    }
    
    public boolean swap(int m, int n, ListNode head){
    	if(m == n){
    		return true;
    	}else if(m < n){  // m...n
    		ListNode mp = head, mt = head, mn = head;
    		ListNode np = head, nt = head, nn = head;
    		for(int i=0; i<m-2;i++){
    			mp = mp.next; 
    		}
    		mt = mp.next;
    		mn = mt.next;
    		
    		for(int i=0; i<n-2;i++){
    			np = np.next; 
    		}
    		nt = np.next;
    		nn = nt.next;

    		//swap 
    		nt.next = mn;
    		mt.next = nn;
    		np.next = mt;
    		mp.next = nt;
    		return true;
    	}else{
    		return swap(n,m,head);
    	}
    }
    public void traverse(ListNode head){
    	ListNode current = head;
    	while(current!=null){
    		System.out.print(current.val + "->");
    		current = current.next;
    	}
    	System.out.println("");
    }
}


