public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode createList(int[] arr){
		LinkedList list = new LinkedList();
		for(int i=0; i<arr.length; ++i){
			list.add(arr[i]);
		}
		return list.start;
	}
	
	public static ListNode createListOdd(){
		int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
		return createList(arr);
	}
	public static ListNode createListEven(){
		int arr[] = new int[]{1,2,3,4,5,6,7,8};
		return createList(arr);
	}
	
	public static void print(ListNode node) {
		ListNode n = node;
		while (n != null) {
			System.out.print(n.val + " -> ");
			n = n.next;
		}
		System.out.println();
		return;
	}
	
	public void print() {
		ListNode n = this;
		while (n != null) {
			System.out.print(n.val + " -> ");
			n = n.next;
		}
		System.out.println();
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
				r = r.next; // remove dummy node
				return r;
			} else if (l1 != null && l2 == null) { // l2 finished
				t.next = l1;
				r = r.next; // remove dummy node
				return r;
			} else { // both finished
				r = r.next; // remove dummy node
				return r;
			}
			t = t.next;
		}
	}

	public static ListNode reverse(ListNode head){
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
		
		/* Go forward m-2 steps 
		 * Ex. if m=5, go 3 steps to the 4th element
		 * */
		for (int i = 0; i < m - 2; ++i) { 
			beforeEntry = beforeEntry.next;
			p1 = p1.next;
			afterEntry = afterEntry.next;
			//System.out.println(">> " + p1.val);
		}
		p1 = p1.next;
		afterEntry = afterEntry.next;
		
		if (p1.next != null)
			p2 = p1.next;
		if (p2.next != null)
			p3 = p2.next;
		
		if(m==1){  //special case 
			p1 = new ListNode(0); //dummy 
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
}
