package linkedlist;

public class _141_LinkedListCycle {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		for(int i=0; i<10; i++){
			list1.add(i);
			list2.add(i);
		}
		list2.end.next = list2.start.next.next;
		//list1.print();
		//list2.print();  //list2 has cycle, don't print it
		
		System.out.println(hasCycle(list1.start));
		System.out.println(hasCycle(list2.start));
		
	}
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
 
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            //if(fast==slow) return true;
            if(fast.next==null) return false;
            if(fast.next.next==null) return false;
            if(fast.next==slow || fast.next.next==slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}