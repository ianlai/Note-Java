package reservoirSampling;

import java.util.Random;

public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode mHead; 
    Random random;
    boolean isDebug=false;
    public Solution(ListNode head) {
        mHead = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = mHead;
        int result = mHead.val;
        debug("------------");
        
        for(int i=0; cur!=null; ++i){
            int r = random.nextInt(i+1);
            debug("i = " + i + "  r = " + r);
            if(r==i){
                result = cur.val;
            }
            cur=cur.next;
        }
        return result;
    }
    public void debug(String s){
    	if(isDebug) System.out.println(s);
    }
}