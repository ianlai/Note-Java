package linkedlist;

/** 
 * If there is cycle    -> return the entrance 
 * If there is no cycle -> return null
 */
public class _142_LinkedListCycle2 {

	public static void main(String[] args) {
		_142_LinkedListCycle2 obj = new _142_LinkedListCycle2();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		for(int i=1; i<8; i++){
			list1.add(i);
			list2.add(i);
		}
		list2.end.next = list2.start.next.next;
		
		ListNode res1 = obj.detectCycle(list1.start);
		ListNode res2 = obj.detectCycle(list2.start);
		
		System.out.println((res1==null)?"null":res1.val);
		System.out.println((res2==null)?"null":res2.val);
	}

    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode f = head;
        ListNode s = head; 
        while(f!=null&&f.next!=null){
            f = f.next.next;
            s = s.next;
            if(f==s){
                /* Detect the cycle. Next find the entrance. */
                ListNode s2 = head;
                while(s!=s2){
                    s  = s.next; 
                    s2 = s2.next;
                }
                return s;
            }
        }
        return null;
    }
}