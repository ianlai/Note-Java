package linkedlist;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class _382_LinkedListRandomNode {

	public static void main(String[] args) {
		ListNode head = ListNode.createListDefault();
		head.print();
		
		Solution s = new Solution(head);
		for(int i=0; i<20;i++){
			System.out.println(s.getRandom());
		}	
	}
}

/** @param head The linked list's head.
Note that the head is guaranteed to be not null, so it contains at least one node. */
class Solution{
ListNode mHead; 
Random random;

public Solution(ListNode head) {
    mHead = head;
    random = new Random();
}

/** Returns a random node's value. */
public int getRandom() {
    ListNode cur = mHead;
    int result = mHead.val;
    
    for(int i=0; cur!=null; ++i){
        int r = random.nextInt(i+1);
        if(r==i){
            result=cur.val;
        }
        cur=cur.next;
    }
    return result;
}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */