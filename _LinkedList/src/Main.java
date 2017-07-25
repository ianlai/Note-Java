//import java.util.LinkedList;  //We define our own

public class Main {
	static LinkedList list1;
	static LinkedList list2;
	static LinkedList list3;

	public static void main(String[] args) {
		
		//=========== LinkedList ===========
		list1 = new LinkedList();
		list1.add(1);
		list1.add(3);
		list1.add(11);
		list1.add(22);
	
		list2 = new LinkedList();
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(30);
		
		list3 = new LinkedList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		list3.add(7);
		
		//=========== ListNode ===========
		
		print3List();
		
		System.out.print("Merge List1 & List2 : ");
		ListNode n3 = ListNode.mergeTwoSortedList(list1.start, list2.start);
		ListNode.print(n3);
		System.out.println();
		
		print3List();
		
		System.out.print("Reverse List1       : ");
		list1.start = ListNode.reverse(list1.start);
		list1.print();
		System.out.println();
		
		print3List();
		
		System.out.print("Reverse List3(3,5)  : ");
		ListNode n5 = ListNode.reverseBetween(list3.start, 3, 5);
		ListNode.print(n5);
		System.out.println();
		ListNode.reverseBetween(list3.start, 3, 5);  //reset 
		
		print3List();
		
		System.out.print("Reverse List3(1,5)  : ");
		ListNode n6 = ListNode.reverseBetween(list3.start, 1, 5);
		ListNode.print(n6);
		System.out.println();
		
		print3List();
		

	}
	private static void print3List(){
		System.out.print("List1               : ");
		list1.print();
		System.out.println();
		System.out.print("List2               : ");
		list2.print();
		System.out.println();
		System.out.print("List3               : ");
		list3.print();
		System.out.println();
		System.out.println("--------------");
	}
	
}
