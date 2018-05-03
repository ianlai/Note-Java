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
    	 *     (0)    (1)    (2)    (3)
    	 * Three input bits: A, B, input 
    	 * Two output bits : NA, NB       //next state A, next state B 
    	 * NA = ~ABI  | A~B~I
    	 * NB = ~A~BI | ~AB~I = ~A(B^I) 
    	 * 
    	 * Because the special element will be at state-1 (once), return B (second).
    	 * If the special element will be at state-2 (twice), then return A (first).
    	 */
        int first  = 0;
        int second = 0;
        for(int i=0; i<nums.length; i++){
            int f = first;    //record
            int s = second;   //not needed, just save the characters
            int t = nums[i];  //not needed, just save the characters
            first  = ~f&s&t | f&~s&~t;   
            second = ~f & (s^t); 
        }
        return isOnce ? second : first;  
    }
}
