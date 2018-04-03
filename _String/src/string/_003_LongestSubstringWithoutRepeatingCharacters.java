package string;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

/* A bit like a DP question in the first glance, but actually it is not */
public class _003_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		_003_LongestSubstringWithoutRepeatingCharacters obj = new _003_LongestSubstringWithoutRepeatingCharacters();
		String s1 = "abkwaababkmm";
		String s2 = "abkeweoibnkkbabaiqlknaoqloeknabkjewkrqln";
		
		System.out.println(obj.lengthOfLongestSubstring1(s1));
		System.out.println(obj.lengthOfLongestSubstring2(s1));
		
		System.out.println(obj.lengthOfLongestSubstring1(s2));
		System.out.println(obj.lengthOfLongestSubstring2(s2));
	}
    /* lastIndexOf */
    public int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        if(length<=1) return length;
        int[] dp = new int[length];
        dp[0] = 1; 
        int max=0;
        int lastIndex = -1;
        for(int i=1; i<length; i++){
            char cur = s.charAt(i); 
            String sub = s.substring(lastIndex+1,i);  //exclusive of i 
            lastIndex = Math.max(sub.lastIndexOf(cur)+lastIndex+1, lastIndex);
            dp[i]=i-lastIndex;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /* HashSet */
    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}