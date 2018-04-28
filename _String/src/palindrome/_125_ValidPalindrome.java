package palindrome;

/* 
 * Considering only alphanumeric characters and ignoring cases.
 */
public class _125_ValidPalindrome {

	public static void main(String[] args) {
		_125_ValidPalindrome palindrome = new _125_ValidPalindrome();

		System.out.println();
		String test1 = "ab"; // false
		boolean answer1 = palindrome.isPalindrome(test1);
		System.out.println(answer1);

		System.out.println();
		String test2 = "ab 9n ,,..11b    a"; // false
		boolean answer2 = palindrome.isPalindrome(test2);
		System.out.println(answer2);

		System.out.println();
		String test3 = "a."; // true
		boolean answer3 = palindrome.isPalindrome(test3);
		System.out.println(answer3);

		System.out.println();
		String test4 = ".,";
		boolean answer4 = palindrome.isPalindrome(test4);
		System.out.println(answer4);

		System.out.println();
		String test5 = "aA";
		boolean answer5 = palindrome.isPalindrome(test5);
		System.out.println(answer5);

		System.out.println();
		String test6 = "0P"; // false
		boolean answer6 = palindrome.isPalindrome(test6);
		System.out.println(answer6);
	}

	public static boolean isPalindrome(String s) {
		System.out.println(">>> " + s);

		if (s.length() == 0)
			return true;
		int head = 0;
		int tail = s.length() - 1;
		while (true) {
			// if(head>=tail) return true;
			while (head < s.length() - 1) {
				char a = s.charAt(head);
				// if(Character.isLetter(a) || Character.isDigit(a)) break;
				// //head points to a letter
				if (Character.isLetterOrDigit(a))
					break; // head points to a letter
				else
					++head;
			}
			while (tail > 0) {
				char b = s.charAt(tail);
				if (Character.isLetter(b) || Character.isDigit(b))
					break; // tail points to a letter
				else
					--tail;
			}
			//System.out.println(">>> head: " + head);
			//System.out.println(">>> tail: " + tail);

			if (!isSame(s, head, tail))
				return false;
			// if(head==tail) return !Character.isLetter(s.charAt(head));
			if (head >= tail)
				return true;

			++head;
			--tail;
		}
	}

	private static boolean isSame(String s, int h, int t) {
		Character a = s.charAt(h);
		Character b = s.charAt(t);
		if (Character.isLetter(a) && Character.isLetter(b)) {
			if (Character.toUpperCase(a) != Character.toUpperCase(b))
				return false; // only care this
		} else if (Character.isDigit(a) && Character.isDigit(b)) {
			if (a != b)
				return false; // only care this
		} else if ((Character.isDigit(a) && Character.isLetter(b)) || (Character.isLetter(a) && Character.isDigit(b))) {
			return false;
		}
		return true;
	}
}