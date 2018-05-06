package string;
/*
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. 
 * For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. 
 * Return True if and only if A can become B after some number of shifts on A.
 * 
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * 
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * 
 * Note:
 * A and B will have length at most 100.
 */
public class _796_RotateString {

	public static void main(String[] args) {
		_796_RotateString obj = new _796_RotateString();
		String A1 = "bcdefa";
		String B1 = "efabcd";
		System.out.println(obj.rotateString(A1, B1));
		
		String A2 = "bcdefaaa";
		String B2 = "efabcd";
		System.out.println(obj.rotateString(A2, B2));
	}
    public boolean rotateString(String A, String B) {
        if(A.length()==0 && B.length()==0) return true;
        StringBuilder sba = new StringBuilder(A);
        for(int i=0; i<A.length(); i++){
            if(sba.toString().equals(B)) return true;
            char head = sba.charAt(0);
            sba = new StringBuilder(sba.substring(1, A.length())).append(head);
        }
        return false;
    }
}