
public class _19_RemoveNFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list1 = new LinkedList();
		for(int i=0; i<10; i++){
			list1.add(i);
		}
		list1.print();
		
		list1.start = removeNthFromEnd(list1.start, 2);  //normal case
		System.out.println();
		list1.print();
		
		list1.start = removeNthFromEnd(list1.start, 9);  //special case (first element)
		System.out.println();
		list1.print();
	}

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0) return null;
        
        ListNode dummy = new ListNode(0); //dummy
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        
        for(int i=0; i<n; ++i){
            if(p2.next!=null)
                p2 = p2.next;
            else
                return head;
        }
        while(p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        //p1.next is the target
        p1.next = p1.next.next;
        if(p1==dummy) return head.next;  //target is the head
        else return head;
    }
}