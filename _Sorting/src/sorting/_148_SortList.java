package sorting;

import linkedlist.ListNode;

public class _148_SortList {

	public static void main(String[] args) {
		_148_SortList obj = new _148_SortList();
		ListNode oriList1 = ListNode.createList(new int[]{5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6});
		ListNode oriList2 = ListNode.createList(new int[]{5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6,5,2,4,8,1,3,6});
		oriList1.print();
		oriList2.print();
		
		System.out.println("====================");
		
		ListNode newList1 = obj.sortList(oriList1);
		ListNode newList2 = obj.sortList2(oriList2);  //Wrong: Stack Overflow in leetcode (cannot reproduce here)
		newList1.print();
		newList2.print();
	}
	/* Correct 
	 * h2.next = merge(h1, h2.next); 
	 * */
    public ListNode sortList(ListNode head) {
    	if(head==null||head.next==null) return head;
    	
    	ListNode pre = head;
    	ListNode p1 = head;
    	ListNode p2 = head;
    	while(p2!=null && p2.next!=null){
    		pre = p1;
    		p1  = p1.next;
    		p2  = p2.next.next;
    	}
    	pre.next = null;  //separate the two sub lists
    	
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);
        return merge(h1,h2);
    }
    public ListNode merge(ListNode h1, ListNode h2){
    	if(h1==null) return h2;
    	if(h2==null) return h1;
    	if(h1.val < h2.val){
    		h1.next = merge(h1.next, h2);
    		return h1;
    	}else{
    		h2.next = merge(h1, h2.next);
    		return h2;
    	}
    }
    //=============================================
	/* Error - StackOverflow 
	 * h2.next = merge(h2.next, h1); 
	 * */
    public ListNode sortList2(ListNode head) {
    	if(head==null||head.next==null) return head;
    	
    	ListNode pre = head;
    	ListNode p1 = head;
    	ListNode p2 = head;
    	while(p2!=null && p2.next!=null){
    		pre = p1;
    		p1  = p1.next;
    		p2  = p2.next.next;
    	}
    	pre.next = null;  //separate the two sub lists
    	
        ListNode h1 = sortList2(head);
        ListNode h2 = sortList2(p1);
        return merge2(h1,h2);
    }
    public ListNode merge2(ListNode h1, ListNode h2){
    	if(h1==null) return h2;
    	if(h2==null) return h1;
    	if(h1.val < h2.val){
    		h1.next = merge2(h1.next, h2);
    		return h1;
    	}else{
    		h2.next = merge2(h2.next, h1);
    		return h2;
    	}
    }
}
