package string;
/* 
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
public class _344_ReverseString {

	public static void main(String[] args) {
		_344_ReverseString obj = new _344_ReverseString();
		
		System.out.println("===== Simple Test =====");
		String str  = "abcde"; 
		String strr = obj.reverseString(str);
		System.out.println(str);
		System.out.println(strr);
		
		System.out.println("===== Test Cases =====");
		String s1  = "zxcvb"  ; String s1r = "bvcxz"  ;
		String s2  = "872mPo "; String s2r = " oPm278";
		String s3  = " $   %("; String s3r = "(%   $ ";
		boolean testResult = true;
		testResult = testResult && s1r.equals(obj.reverseString(s1));
		testResult = testResult && s2r.equals(obj.reverseString(s2));
		testResult = testResult && s3r.equals(obj.reverseString(s3));
		String msgResult = (testResult == true) ? "All test passed!" : "Test failed...";
		System.out.println(msgResult);
	}
    public String reverseString(String s) {
        char[] carr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            carr[i] = s.charAt(s.length()-1-i);
        }
        String ans = new String(carr);
        return ans;
    }
}