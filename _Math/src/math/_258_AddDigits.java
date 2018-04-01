package math;

/* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */

public class _258_AddDigits {

	public static void main(String[] args) {
		_258_AddDigits obj = new _258_AddDigits();
		int a1 = 44579; //4+4+5+7+9=29 -> 2+9=11 -> 1+1=2 
		int a2 = 9981;  //9+9+8+1  =27 -> 2+7=9
		System.out.println(a1 + "->");
		System.out.println(obj.addDigits(a1));
		System.out.println(a2 + "->");
		System.out.println(obj.addDigits(a2));
	}
    public int addDigits(int num) {
        if(num==0) return 0; 
        if(num%9==0) return 9;
        return num%9;
    }
}