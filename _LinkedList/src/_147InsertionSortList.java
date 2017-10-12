
public class _147InsertionSortList {
	public static void main(String[] args) {
		_147InsertionSortList obj = new _147InsertionSortList();
		// int[] arr = new int[]{3,8,5,1,4,9,6};
		// int[] arr = new int[] { 1, 1, 8, 3 };
		// int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
	   int[] arr = new int[]{3, 7, 1, 2, 2, 5, 8, 4, 0 , 1 ,7, 8 ,9 , 3, 5, 5,1,-5, -3};

		ListNode list = ListNode.createList(arr);
		// list.print();

		list = obj.insertionSortList(list);
		System.out.println("Final Answer:");
		// list = ListNode.swap(list, 6, 1);

		list.print();
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode dummyNewList = new ListNode(0);
		while (head != null) {
			ListNode node = dummyNewList;
			while (node.next != null && node.next.val < head.val) {
				node = node.next;
			}
			ListNode temp = head.next; // keep the head
			head.next = node.next; // connect backward
			node.next = head; // connect forward
			head = temp;
		}
		return dummyNewList.next;
	}

	public ListNode insertionSortListSlow(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode cp = head;
		ListNode cc = head.next; // from second one
		ListNode cn = head.next.next; // might be null
		if (cn == null) {
			if (cp.val <= cc.val) {
				return head;
			} else {
				cp.next = null;
				cc.next = cp;
				return cc;
			}
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode tc = head;
		ListNode tp = dummy;
		tp.next = tc;

		while (cc != null) {
			int count = 0;
			System.out.println("===============");
			String debug = tp + " " + tc + " | " + cp + " " + cc + " " + cn;
			System.out.println("round       " + debug);

			head.print();

			while (tc != cc && tc.val < cc.val) {
				tc = tc.next;
				tp = tp.next;
				// System.out.println("in " + tc + " " + cc);
				count++;
			}
			debug = tp + " " + tc + " | " + cp + " " + cc + " " + cn;
			System.out.println("before swap " + debug);

			/* swap */
			if (tc != cc) {
				cc.next = tc;
				tp.next = cc;
				cp.next = cn; // across
				if (count == 0)
					head = cc;
				debug = tp + " " + tc + " | " + cp + " " + cc + " " + cn;
				System.out.println("after swap " + debug);
				head.print();
			} else {
				debug = tp + " " + tc + " | " + cp + " " + cc + " " + cn;
				System.out.println("no    swap " + debug);
			}

			/* test the next one */

			// cp = cp.next;
			cc = cn;
			if (cn != null)
				cn = cn.next;
			cp = dummy;
			if (cc == null)
				return head;
			while (cp.next != cc)
				cp = cp.next;

			tc = head; // reset
			tp = dummy; // reset
		}
		return head;
	}
}
