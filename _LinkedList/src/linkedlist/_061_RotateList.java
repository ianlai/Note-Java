package linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

public class _061_RotateList {

	public static void main(String[] args) {
		_061_RotateList obj = new _061_RotateList();
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