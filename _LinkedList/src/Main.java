public class Main {

	public static void main(String[] args) {
		
		//=========== LinkedList ===========
		LinkedList list1 = new LinkedList();
		list1.add(1);
		list1.add(3);
		list1.add(11);
		list1.add(22);
	
		LinkedList list2 = new LinkedList();
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(30);
		
		LinkedList list3 = new LinkedList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		list3.add(7);
		
		//=========== ListNode ===========
		System.out.print("List1      : ");
		ListNode.print(list1.start);
		System.out.println();
		System.out.print("List2      : ");
		ListNode.print(list2.start);
		System.out.println();
		
		System.out.print("Merged List: ");
		ListNode n3 = ListNode.mergeTwoSortedList(list1.start, list2.start);
		ListNode.print(n3);
		System.out.println();
		
		System.out.print("List3      : ");
		ListNode.print(list3.start);
		System.out.println();
		ListNode root = ListNode.reverseBetween(list3.start, 1, 7);
		System.out.print("Reversed List3  : ");
		ListNode.print(root);
	}

}
