package bits;

/* Every element appears THREE times, except one only appears ONCE. Find it. 
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * */

public class _137_SingleNumber2 {

	public static void main(String[] args) {
		_137_SingleNumber2 obj = new _137_SingleNumber2();
		int[] arr1 = new int[]{1,1,1,3,3,3,7,7,7,8,8,66,8,4,4,4};  //66 once
		int[] arr2 = new int[]{1,1,1,3,3,3,99,99,7,7,7,8,8,5,5,5,8,4,4,4}; //99 twice
		
		System.out.println(obj.singleNumber(arr1, true));   //correct
		System.out.println(obj.singleNumber(arr1, false));  
		
		System.out.println(obj.singleNumber(arr2, true));   
		System.out.println(obj.singleNumber(arr2, false));  //correct
	}
    public int singleNumber(int[] nums, boolean isOnce) {
        
    	/* Three 3 states need to be record, we use two bits. 
    	 * 
    	 * Define the state transition to be 
    	 * AB: 00  -> 01  -> 10  -> 00 
    	 *     (0)    (1)    (2)    (3)   //we want to capture (1) and (2), so let (3) disappear 
    	 * Three input bits: A, B, input 
    	 * Two output bits : NA, NB       //next state A, next state B (just for keeping the original A, B)
    	 * 
    	 * [Current]   [Next]
    	 * A  B  I  ->  NA NB
    	 * 0  0  0      0  0  (0, not changed) 
    	 * 0  1  0      0  1  (1, not changed) 
    	 * 1  0  0      1  0  (2, not changed) 
    	 * 
    	 * 0  0  1      0  1  (0->1, changed) 
    	 * 0  1  1      1  0  (1->2, changed) 
    	 * 1  0  1      0  0  (2->3, changed) 
    	 * 
    	 * NA = (~A)BI    | A(~B)(~I)
    	 * NB = (~A)B(~I) | (~A)(~B)I  
    	 * 
    	 * Because the special element will be at state-1 (once), return B (second).
    	 * If the special element will be at state-2 (twice), then return A (first).
    	 */
    	int A = 0;
    	int B = 0;
        for(int i=0; i<nums.length; i++){
            int I = nums[i];
            //int NA = A&(~B)&(~I) | A&B&(~I) | (~A)&B&I | A&(~B)&I;
            //int NB = (~A)&B&(~I) | A&B&(~I) | (~A)&(~B)&I | A&(~B)&I;
            int NA = A&(~B)&(~I)   | (~A)&B&I;
            int NB = (~A)&B&(~I)   | (~A)&(~B)&I;
            A = NA;
            B = NB;
        }
        //return isOnce ? B : A;   //Explicitly capture 01 (1) or 10 (2) 
        return A|B;  //Capture both 01 and 10. Both A|B and A^B are fine.
    }
}
