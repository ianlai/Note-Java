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
		
		ListNode l1 = ListNode.createList(arr1);
		l1.print();
		
		ListNode l2 = obj.reverseBetween(l1, 3, 8);
		l2.print();
		
		ListNode l3 = obj.reverseBetween(l1, 1, 10);
		l3.print();

	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
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