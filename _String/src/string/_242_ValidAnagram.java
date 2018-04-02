package string;

import java.util.Arrays;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class _242_ValidAnagram {

	public static void main(String[] args) {
		_242_ValidAnagram obj = new _242_ValidAnagram();
		boolean b1 = obj.isAnagram("aauhuzz", "zuhazau");         //true
		boolean b2 = obj.isAnagram("aauhuokkhzz", "zuhazakhnu");  //false
		System.out.println(b1);
		System.out.println(b2);
	}
    public boolean isAnagram(String s, String t) {
        int[] az = new int[26];
        Arrays.fill(az,0);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            az[c-97]++;
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            az[c-97]--;
        }
        for(int e: az){
            if(e!=0) return false;
        }
        return true;
    }
}