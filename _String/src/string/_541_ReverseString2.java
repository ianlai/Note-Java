package string;

/* Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
 * counting from the start of the string.
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 */
public class _541_ReverseString2 {

	public static void main(String[] args) {
		String s1 = "abcdefghijklmn";
		String s2 = reverseStr(s1, 3);
		String s3 = reverseStr(s1, 4);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

	public static String reverseStr(String s, int k) {
		if (s == null || s.length() == 0)
			return s;
		int length = s.length();
		char[] arr = s.toCharArray();
		char[] brr = s.toCharArray();

		if (k <= 1) {
			return s;
		} else if (k >= length) {
			for (int i = 0; i < length; i++) {
				brr[length - 1 - i] = arr[i];
			}
		} else if (k < length) {
			int group = 0;
			int count = 0;
			int left = k;
			boolean rev = true;
			for (int i = 0; i < length; i++) {

				/* For the condition that k~2k, 3k~4k, ... not reverse */
				if (!rev && count < k) {
					count++;
					continue;
				}
				if (!rev && count == k) {
					rev = true;
					if (group + k + k > length - 1) {
						group += k;
						count = 0;
						left = length - group;
					} else {
						group += k;
						count = 0;
					}
				}

				/* For debug */
				// int t = left-1-count+group;
				// System.out.println(""+ t+ " " +group + " " + count + " l:" +
				// left);
				brr[left - 1 - count + group] = arr[group + count];

				count++;
				if (count == k) {
					rev = false;
					/* last group, left element might less than a group size */
					if (group + k + k > length - 1) {
						group += k;
						count = 0;
						left = length - group;
					} else {
						group += k;
						count = 0;
					}
				}
			}
		}
		String res = new String(brr);
		return res;
	}
}