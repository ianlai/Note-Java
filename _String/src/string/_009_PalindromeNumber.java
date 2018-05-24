package string;
/*
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 * 
	Example 1:
	Input: 121
	Output: true
	
	Example 2:
	Input: -121
	Output: false
	Explanation: From left to right, it reads -121. 
	From right to left, it becomes 121-. Therefore it is not a palindrome.
	
	Example 3:
	Input: 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	
	Follow up:
	Coud you solve it without converting the integer to a string?
 */
public class _009_PalindromeNumber {

	public static void main(String[] args) {
		_009_PalindromeNumber obj = new _009_PalindromeNumber();
		int[] arr = new int[]{123,555,877,194878491,-559955,+289982};  //-559955 is not
		for(int e: arr){
			System.out.println(e + ": " + obj.isPalindrome(e));
		}
	}

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
//        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
//            s.substring(1);
//        }
        if(s.charAt(0)=='-') return false;  //negative number should always be false
        
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}