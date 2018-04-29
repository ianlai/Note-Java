package palindrome;
/*
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input:  "bbbab"
 * Output: 4
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: 2
 * One possible longest palindromic subsequence is "bb".
 */

/* Subsequence means it does not need to be continuous */
/* Use top-down DP to solve this */
public class _516_LongestPalindromicSubsequence {

	public static void main(String[] args) {
		_516_LongestPalindromicSubsequence obj = new _516_LongestPalindromicSubsequence();
		
		String s1 = "aabbbca";           //abbba -> 5
		System.out.println(s1 + ": " + obj.longestPalindromeSubseq(s1));
		 
		String s2 = "cbcaabbcbbaacabc";  //cbc aabbcbbaa cbc -> 15
		System.out.println(s2 + ": " + obj.longestPalindromeSubseq(s2));
	}

    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0) return 0;
        int[][] table = new int[s.length()][s.length()];
        return dp(s, table, 0, s.length()-1);
    }
    private int dp(String s, int[][] t, int l, int r){
        if(l>r || l<0 || r>=s.length()) return 0;
        if(l==r) return 1;
        if(t[l][r]==0){
            int firstCharAsR = s.indexOf(s.charAt(r), l);
            int withR = -1; 
            int withoutR = -1;
            if(firstCharAsR == r){
                withR = 1; 
            }else{
                withR = dp(s, t, firstCharAsR+1, r-1) + 2;
            }
            withoutR = dp(s, t, l, r-1);
            t[l][r] = Math.max(withR, withoutR);
        }
        return t[l][r];
    }
}