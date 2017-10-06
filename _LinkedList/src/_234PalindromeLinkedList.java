//  https://leetcode.com/problems/palindrome-linked-list/description/
	
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _234PalindromeLinkedList {

	public static void main(String[] args) {
		_234PalindromeLinkedList obj = new _234PalindromeLinkedList();
		
		ListNode listodd = ListNode.createListOdd();
		ListNode listeven= ListNode.createListEven();
		
		obj.isPalindrome(listodd);
		obj.isPalindrome(listeven);
	}

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        if(head.next.next==null && head.val==head.next.val) return true;
        
        ListNode s = head;
        ListNode f = head;
        
        /* Half it and reverse */ 
        while(true){
        	//f==null:even, f.next==null:odd 
        	if(f==null || f.next==null){
        		s = reverse(s);
        		break;
        	}
            s = s.next;
            f = f.next.next; 
        }
        
        /* Compare */
        ListNode tail = s; 
        while(tail!=null){
        	if(head.val != tail.val) return false;
        	head = head.next;
        	tail = tail.next; 
        }
        return true;
    }
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = next; 
        }
        return prev; 
    }
    
    //----------------------------------------------------
    
    /* Use list: Not constant space */
    
    // public boolean isPalindrome(ListNode head) {
    //     ListNode n = head;
    //     if(n==null) return true;
    //     List<Integer> list = new ArrayList<>();
    //     while(n!=null){
    //         list.add(n.val);
    //         n = n.next;
    //     }
    //     System.out.println(list);
    //     int i=0;
    //     int j=list.size()-1;
    //     /* CANNOT use double equal to determin whether they are same or not */
    //     //System.out.println(list.get(i).equals(list.get(j)));
    //     while(i<j){
    //         if(!list.get(i).equals(list.get(j))) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;   
    // }
}