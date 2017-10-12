/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _61RotateList {

	public static void main(String[] args) {
		_61RotateList obj = new _61RotateList();
		ListNode list = ListNode.createListEven();
		list.print();
		list = obj.rotateRight(list, 3);
		list.print();
	}

	/* Walk through the list twice. This should be revised. */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode curr = head;
        int size = 0;
        int forwardCount = 0;
        while(curr.next!=null){
            size++;
            curr = curr.next; 
        }
        curr.next = head;  //curr points to the tail, makes it a cycle 
        size+=1;           //real size
        
        k %= size;
        forwardCount = size-k-1 ;
        curr = head;
        for(int i=0; i<forwardCount; i++){
            curr = curr.next;
        }
        head = curr.next; 
        curr.next = null; 
        return head; 
    }
}