package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _021_MergeTwoSortedLists {

	public static void main(String[] args) {
		_021_MergeTwoSortedLists obj = new _021_MergeTwoSortedLists();
		int[] arr1 = new int[]{1,5,7,8,13,19,25};
		int[] arr2 = new int[]{4,5,6,7,12,17,18,29};
		
		ListNode l1 = ListNode.createList(arr1);
		ListNode l2 = ListNode.createList(arr2);
		ListNode l3 = obj.mergeTwoLists(l1, l2);
		ListNode.print(l3);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
