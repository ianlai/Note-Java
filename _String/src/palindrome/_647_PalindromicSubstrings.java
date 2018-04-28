package palindrome;
/*
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * 
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * Note:
 * The input string length won't exceed 1000.
 */

/* Different indexes considered as different substrings */
public class _647_PalindromicSubstrings {

	public static void main(String[] args) {
		_647_PalindromicSubstrings obj = new _647_PalindromicSubstrings();
		String s1 = "abccbab";  //a,b,c,cc,bccb,abccba,c,b,a,bab,b (11)
		System.out.println(s1);
		System.out.println(obj.countSubstrings(s1));
	}
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int[] ans = new int[1];
        
        for(int i=0; i<s.length(); i++){
            helper(i, i, s, ans);
            helper(i, i+1, s, ans);
        }
        return ans[0];
    }
    public void helper(int l, int r, String s, int[] count){
        if(l<0 || r>=s.length()) return;
        if(s.charAt(l)==s.charAt(r)){
            count[0]++;
            //System.out.println(l + " " + r);
            helper(l-1, r+1, s, count);
        }
        return; 
    }
}