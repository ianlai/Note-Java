package algo;

public class Main {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		
		System.out.println();
		String test1="ab";                  //false
		boolean answer1 = palindrome.isPalindrome(test1);
		System.out.println(answer1);
		
		System.out.println();
		String test2="ab 9n ,,..11b    a";  //true
		boolean answer2 = palindrome.isPalindrome(test2);
		System.out.println(answer2);
		
		System.out.println();   
		String test3="a.";                  //true
		boolean answer3 = palindrome.isPalindrome(test3);
		System.out.println(answer3);
		
		System.out.println();
		String test4=".,";
		boolean answer4 = palindrome.isPalindrome(test4);
		System.out.println(answer4);
		
		System.out.println();
		String test5="aA";
		boolean answer5 = palindrome.isPalindrome(test5);
		System.out.println(answer5);
		
		System.out.println();
		String test6="0P";                  //false
		boolean answer6 = palindrome.isPalindrome(test6);
		System.out.println(answer6);
	}

}
