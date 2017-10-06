import java.util.Arrays;

//
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
// Given 1->1->2->3->3, return 1->2->3.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class _83RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,2,2,2,2,3,4,4,5};
		ListNode list = ListNode.createList(arr);
		ListNode.print(list);
		System.out.println();
		ListNode.print(deleteDuplicates(list));
		
		//System.out.println(-129==-129);
		
	}
    public static ListNode deleteDuplicates(ListNode head) {
        
        ListNode cur = head;
        
        if(head==null) return head;   //null
    
        ListNode t = cur.next;
        if(t==null) return head;  //1 element
        
        while(cur!=null){
            //System.out.println(">" + cur.val + " " + t.val);
            while(cur.val==t.val){
                if(t.next==null){
                    cur.next = null;
                    return head;
                }else{
                    t = t.next;
                }
            }
            cur.next = t;
            cur = cur.next;
            if(t.next==null) break;
            else t = t.next; 
        }
        return head; 
    }
}