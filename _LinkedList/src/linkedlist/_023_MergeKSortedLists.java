package linkedlist;

import java.util.PriorityQueue;

public class _023_MergeKSortedLists {

	public static void main(String[] args) {
		_023_MergeKSortedLists obj = new _023_MergeKSortedLists();
		
		ListNode l1 = ListNode.createList(new int[]{4,7,8,10,15});
		ListNode l2 = ListNode.createList(new int[]{3,4,6,7,9});
		ListNode l3 = ListNode.createList(new int[]{1,5,13,14,16});
		ListNode l4 = ListNode.createList(new int[]{2,4,7,9,12});
		ListNode[] ll= new ListNode[4];
		ll[0] = l1;
		ll[1] = l2;
		ll[2] = l3;
		ll[3] = l4;
		
		ListNode list = obj.mergeKLists(ll);
		list.print();
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (ListNode n1, ListNode n2) -> n1.val - n2.val);

		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		/* first round */
		for (ListNode n : lists) {
			if (n != null)
				pq.add(n);
		}

		/* all the other rounds */
		while (!pq.isEmpty()) {
			curr.next = pq.poll();
			curr = curr.next;
			if (curr.next != null)
				pq.add(curr.next);
		}
		return dummy.next;
	}
}