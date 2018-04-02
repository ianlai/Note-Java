package linkedlist;

/* 
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class _203_RemoveLinkedListElements {

	public static void main(String[] args) {
		_203_RemoveLinkedListElements obj = new _203_RemoveLinkedListElements();
		
		ListNode l1 = ListNode.createList(new int[]{1,2,6,3,2,7,8});
		System.out.println("L1:");
		l1.print();
		l1 = obj.removeElements(l1, 2);
		l1.print();
		
		ListNode l2 = ListNode.createList(new int[]{9,2,6,3,2,9,9});
		System.out.println("L2:");
		l2.print();
		l2 = obj.removeElements(l2, 9);
		l2.print();
		
		ListNode l3 = ListNode.createList(new int[]{0,0,0,0,0,0,0});
		System.out.println("L3:");
		l3.print();
		l3 = obj.removeElements(l3, 0);
		l3.print();  //null point exception because there is nothing inside so we cannot print it
	}
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy; 
        while(cur!=null && cur.next!=null){
            while(cur.next!=null && cur.next.val==val) cur.next = cur.next.next; 
            if(cur.next==null) break;
            cur = cur.next;
        }
        return dummy.next;
    }
}