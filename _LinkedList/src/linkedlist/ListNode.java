package linkedlist;
public class ListNode{
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode createListDefault(){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		return createList(arr);
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
	
	public static ListNode swap(ListNode head, int m, int n){
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		m = max;
		n = min;

		ListNode dummy = new ListNode(-1);
		dummy.next = head; 
		
		ListNode mc = head; 
		ListNode mp = dummy;  //prev
		ListNode mn = head.next;  //next
		
		ListNode nc = head; 
		ListNode np = dummy;  //prev
		ListNode nn = head.next;  //next
		
		for(int i=0 ; i<n-1; ++i){
			mc = mc.next;
			mp = mp.next;
			mn = mn.next;
			
			nc = nc.next;
			np = np.next;
			nn = nn.next;
		}
		for(int i=0 ; i<m-n; ++i){
			mc = mc.next;
			mp = mp.next;
			mn = mn.next;
		}
		
		mc.next = nn;
		mp.next = nc; 
		nc.next = mn;
		np.next = mc; 
		
		return (n==1) ? mc : head;
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

	@Override
	public String toString() {
		return "[" + val + "]";
	}
}
