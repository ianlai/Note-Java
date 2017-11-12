package linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _002_AddTwoNumbers {

	public static void main(String[] args) {
		_002_AddTwoNumbers obj = new _002_AddTwoNumbers();
		{
			//9-8 (89)
			ListNode l1 = new ListNode(9); 
			l1.next = new ListNode(8);
			
			//5-7 (75)
			ListNode l2 = new ListNode(5); 
			l2.next = new ListNode(7);  
			
			//4-6-1 (164)
			ListNode l3 = obj.addTwoNumbers(l1, l2);
			l3.print();
		}
		{
			//9-8-9 (989)
			ListNode l1 = new ListNode(9); 
			l1.next = new ListNode(8);
			l1.next.next = new ListNode(9);
			
			//5-7 (75)
			ListNode l2 = new ListNode(5); 
			l2.next = new ListNode(7);  
			
			//4-6-0-1 (1064)
			ListNode l3 = obj.addTwoNumbers(l1, l2);
			l3.print();
		}
		{
			//9-8 (89)
			ListNode l1 = new ListNode(9); 
			l1.next = new ListNode(8);
			
			//5-7-6 (675)
			ListNode l2 = new ListNode(5); 
			l2.next = new ListNode(7);  
			l2.next.next = new ListNode(6);
			
			//4-6-7 (764)
			ListNode l3 = obj.addTwoNumbers(l1, l2);
			l3.print();
		}
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        boolean carry= false;
        
        /* Let l1 be the base */
        while(l1!=null){
            if(l2!=null){
                int sum = 0;
                if(carry){
                    sum = l1.val+l2.val+1;
                }else{
                    sum = l1.val+l2.val;
                }
                if(sum>9){
                    l3.val = sum % 10;
                    carry = true;
                }else{
                    l3.val = sum;
                    carry = false;
                }
                l2 = l2.next; 
            }else{
                /* l2 finished */
                int sum = (carry) ? l1.val+1 : l1.val;
                carry = sum>9 ? true : false;
                l3.val = sum%10;
            }
            l1 = l1.next;
            if(l1!=null){   //to avoid the last leading 0 in l3 
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
        }
        /* l1 finished, but l2 still left */
        while(l2!=null){
            l3.next = new ListNode(0);
            l3 = l3.next;
            
            int sum = 0;
            sum = (carry) ? l2.val+1 : l2.val;
            carry = sum>9 ? true : false;
            l3.val = sum%10;
            
            l2 = l2.next;
        }
        /* Both l1 and l2 finished, but the carry still left */
        if(carry){
            l3.next = new ListNode(1);
            l3 = l3.next;
        }
        return head;
    }
}