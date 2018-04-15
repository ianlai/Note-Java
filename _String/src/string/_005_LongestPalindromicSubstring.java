package string;
/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */

public class _005_LongestPalindromicSubstring {

	public static void main(String[] args) {
		_005_LongestPalindromicSubstring obj = new _005_LongestPalindromicSubstring();
		String s1 = "momabcdddcbattyy";
		String s2 = "dddddkkkkkkkkkkkmmnnoonnm";
		String s3 = "weiruwyiuvaabbbbbbcccddcccbbbbbbbaawiiwaabbbbbbbb";
		
		System.out.println(obj.longestPalindrome(s1));
		System.out.println(obj.longestPalindrome(s2));
		System.out.println(obj.longestPalindrome(s3));
	}

    int mMax = 0;
    int mL = 0;
    int mR = 0;
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1) return s;
        int len = s.length();
        for(int i=0; i<len; i++){
            helper(s,i,i);    //start with single char 
            helper(s,i,i+1);  //start with double chars
        }
        return s.substring(mL, mR+1);   //right side is exclusive
    }
    private void helper(String s, int l, int r){
        if(l<0 || r>=s.length()) return;
        char cl=s.charAt(l);
        char cr=s.charAt(r);
        if(cl==cr){
            int length = r-l+1;
            if(length>mMax){
                mMax = length;
                mL = l;
                mR = r;
            }
            helper(s, l-1, r+1);
        }
        return; 
    }
}