package linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _092_ReverseLinkedList2 {

	public static void main(String[] args) {
		_092_ReverseLinkedList2 obj = new _092_ReverseLinkedList2();
		int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		System.out.println("===== Original =====");
		ListNode l11 = ListNode.createList(arr1);
		ListNode l12 = ListNode.createList(arr1);
		l11.print();
		l12.print();
		
		System.out.println("===== Reverse(3,8) =====");
		ListNode l21 = obj.reverseBetween(l11, 3, 8);
		ListNode l22 = obj.reverseBetween2(l12, 3, 8);
		l21.print();
		l22.print();
		
		System.out.println("===== Reverse(1,10) =====");
		ListNode l31 = obj.reverseBetween(l11, 1, 10);
		ListNode l32 = obj.reverseBetween(l12, 1, 10);
		l31.print();
		l32.print();
	}
	
	/* This solution is clearer. 
	 * Each iteration will add one node to reverse. 
	 * For example: 
	 *  ori:  1-2-3-4-5-6-7-8, m=3 n=7
	 *  r1 :  1-2-4-3-5-6-7-8
	 *  r2 :  1-2-5-4-3-6-7-8
	 *  r3 :  1-2-6-5-4-3-7-8
	 *  r4 :  1-2-7-6-5-4-3-8  //done 
	 * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode np = dummy;     //pre, m-1 [fixed]
        ListNode ns = head;      //start, m [fixed: position is moving but the node is fixed]
        ListNode nn = head.next; //next to start [dynamic]
        
        /* np=m-1  ns=m  nn=m+1 */
        for(int i=0; i<m-1; i++){
            np = np.next;
        }
        ns = np.next;
        nn = ns.next;
        
        /* Reverse */
        for(int i=0; i<n-m; i++){
            ns.next = nn.next; 
            nn.next = np.next; 
            np.next = nn; 
            nn = ns.next; 
        }
        return dummy.next;
    }
	
	/* This solution is easier to think but complicated to implement. 
	 * It reverses the nodes between m to n directly. */ 
    public ListNode reverseBetween2(ListNode head, int m, int n) {
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
			//System.out.println(i);
		}
		p1 = p1.next;
		afterEntry = afterEntry.next;
		
		if (p1.next != null)
			p2 = p1.next;
		if (p2.next != null)
			p3 = p2.next;
		
		if(m==1){  //special case, handle separately
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