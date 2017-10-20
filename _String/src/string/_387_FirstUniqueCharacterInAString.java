package string;

import java.util.Arrays;

public class _387_FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		_387_FirstUniqueCharacterInAString obj = new _387_FirstUniqueCharacterInAString();
		int r1 = obj.firstUniqChar("leetcode");     //0
		int r2 = obj.firstUniqChar("loveleetcode"); //2
		System.out.println(r1);
		System.out.println(r2);
	}

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int[] arr = new int[26];
		int[] brr = new int[26];
		Arrays.fill(arr, 0);
		Arrays.fill(brr, -1);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int position = (int) c - 97;
			arr[position]++;
			if (arr[position] == 1)
				brr[position] = i;
		}
		int min = s.length();
		for (int i = 0; i < 26; i++) {
			if (arr[i] == 1) {
				min = Math.min(min, brr[i]);
			}
		}
		return min == s.length() ? -1 : min;
	}
}
