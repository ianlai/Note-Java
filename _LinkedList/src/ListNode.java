public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static void print(ListNode node) {
		ListNode n = node;
		while (n != null) {
			System.out.print(n.val + " -> ");
			n = n.next;
		}
		return;
	}

	public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null && l2 != null)
			return l2;
		if (l1 != null && l2 == null)
			return l1;
		ListNode r = new ListNode(0); // dummy
		ListNode t = r;
		while (true) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) { // add l1
					t.next = l1;
					l1 = l1.next;
				} else { // add l2
					t.next = l2;
					l2 = l2.next;
				}
			} else if (l1 == null && l2 != null) { // l1 finished
				t.next = l2;
				r = r.next; // deduct first node
				return r;
			} else if (l1 != null && l2 == null) { // l2 finished
				t.next = l1;
				r = r.next; // deduct first node
				return r;
			} else { // both finished
				r = r.next; // deduct first node
				return r;
			}
			t = t.next;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		if (m == n)
			return head;
		if (head.next.next == null && m == 1 && n == 2) { // only two nodes
			ListNode p1 = head;
			ListNode p2 = head.next;
			p2.next = p1;
			p1.next = null;
			return p2;
		}
		// three nodes and m differs from n (normal case)
		ListNode beforeEntry = head;
		ListNode afterEntry = head;
		ListNode p1 = head;
		ListNode p2 = null;
		ListNode p3 = null;
		for (int i = 0; i < m - 2; ++i) { // go forward m-2 steps
			beforeEntry = beforeEntry.next;
			p1 = p1.next;
			afterEntry = afterEntry.next;
			System.out.println(i);
		}
		p1 = p1.next;
		afterEntry = afterEntry.next;
		
		if (p1.next != null)
			p2 = p1.next;
		if (p2.next != null)
			p3 = p2.next;
		
		if(m==1){
			p1.next=head;
			for (int i = 0; i < n-m-1; ++i) {
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				if (p3!= null)
					p3 = p3.next;
			}
			head = p1;
			beforeEntry.next = p2;
		}else{
			for (int i = 0; i < n-m; ++i) {
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				if (p3!= null)
					p3 = p3.next;
			}
			
			beforeEntry.next = p1;
			afterEntry.next = p2;
		}
		return head;
	}

	// if(l1==null && l2==null) return null;
	// if(l1==null && l2!=null) return l2;
	// if(l1!=null && l2==null) return l1;
	// ListNode h1 = l1;
	// ListNode h2 = l2;
	//
	// while(l1.next!=null && l2.next!=null){
	// if(l1.next.val > l2.val){
	// ListNode temp1 = l1.next;
	// l1.next = l2;
	// while(l2.next.val > temp1.val){
	// l2 = l2.next;
	// }
	// ListNode temp2 = l2.next;
	// l2.next = temp1;
	// }
	// l1 = l1.next;
	// }
	// if(l1.next==null && l2.next!=null){ //l1 finished
	// l1.next = l2;
	// }
	// if(l1.next!=null && l2.next==null){ //l2 finished
	// l2.next = l1;
	// return h2;
	// }
	// if(l1.next==null && l2.next==null){
	// if(l1.val > l2.val){
	// l2.next = l1;
	// return h2;
	// }
	// else{
	// l1.next = l2;
	// }
	// }
	// return h1;

}
