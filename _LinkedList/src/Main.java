public class Main {

	public static void main(String[] args) {
		
		//=========== LinkedList ===========
		LinkedList list1 = new LinkedList();
		System.out.print("List1      : ");
		list1.add(1);
		list1.add(3);
		list1.add(11);
		list1.add(22);
		//list1.print();
		
		System.out.println();
		
		LinkedList list2 = new LinkedList();
		System.out.print("List2      : ");
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(30);
		//list2.print();
		
		System.out.println();
		
		//=========== ListNode ===========
		System.out.print("List1      : ");
		ListNode.print(list1.start);
		System.out.println();
		System.out.print("List2      : ");
		ListNode.print(list2.start);
		System.out.println();
		
//		ListNode temp = new ListNode(5);
//		if(temp.next == null){
//			System.out.println("null");
//		}
		
		System.out.print("Merged List: ");
		ListNode n3 = ListNode.mergeTwoSortedList(list1.start, list2.start);
		ListNode.print(n3);
	
	}

}
