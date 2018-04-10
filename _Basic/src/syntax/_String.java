package syntax;

import java.util.ArrayList;
import java.util.List;

public class _String {

	public static void main(java.lang.String[] args) {
		calcCharOccurence();
		stringBuilderUse();
		stringImmutable();
		typeConversion();
		stringEquality();
		stringDivide();
		testSubstring();
	}

	public static void calcCharOccurence() {
		System.out.println("==========");
		// Calculate char's occurrence
		String s = "abcdababbcdefg"; // b:4
		Character target = new Character('b');
		int count = s.length() - s.replaceAll(target.toString(), "").length(); // calculate the number of 'b'
		System.out.println(count);
	}

	public static void stringBuilderUse() {
		System.out.println("==========");
		String ss = "";
		StringBuilder sb = new StringBuilder();
		String sb_final;
		int number = 10_000;
		long start_ss = System.nanoTime();
		for (int i = 0; i < number; i++) {
			ss += i;
		}
		long end_ss = System.nanoTime();

		long start_sb = System.nanoTime();
		for (int i = 0; i < number; i++) {
			sb.append(i);
		}
		sb_final = sb.toString();
		long end_sb = System.nanoTime();

		boolean check = (ss.equals(sb_final));
		System.out.println("String equals to StringBuilder? " + check);
		System.out.println("String:        " + (end_ss - start_ss));
		System.out.println("StringBuilder: " + (end_sb - start_sb));
	}

	/* Copying a string doesn't need to use clone because String is immutable. 
	 * Wecan copy reference only instead.
	 */
	public static void stringImmutable() {
		System.out.println("==========");
		String s1 = "aaaaabbbbb";
		String s2 = "";
		s2 = s1;
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		s1 = "ooo";
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s2 won't change by s1");
	}

	public static void typeConversion() {
		System.out.println("==========");
		int pp = 3;
		Integer ppp = new Integer(pp);
		String sss1 = String.valueOf(pp);
		String sss2 = ppp.toString();
		String sss3 = "45678";
		Integer ppp2 = Integer.valueOf(sss3);
		System.out.println(sss1 + " " + sss2 + " " + (pp + ppp2));
		
		/* char -> String */
		char c = 'a';
		String s = Character.toString(c);
		System.out.println(s);
	}

	public static void stringEquality() {
		System.out.println("==========");

		String sn1 = new String("aaa");
		String sn2 = new String("aaa");

		System.out.println(sn1 == sn2); // false
		System.out.println(sn1.equals(sn2)); // true

		String ss1 = "bbb";
		String ss2 = "bbb";
		System.out.println(ss1 == ss2); // TRUE (string pool)
		System.out.println(ss1.equals(ss2)); // true

		String ss3 = "b" + "b" + "b";
		System.out.println(ss1 == ss3); // TRUE again (static string in compile time)
	}
	public static void stringDivide(){
		System.out.println("==========");
		List<String> list = new ArrayList<>();
		String origin = "ab cd efg hjiilk ppon";
		for(String s: origin.split(" ")){
			list.add(s);
		}
		for(String s: list){
			System.out.println(s);
		}
	}
	public static void testSubstring(){
		System.out.println("==========");
		String s = "abcdefgabc";
		System.out.println(s.substring(2, 3));  //begin index, end index
		System.out.println(s.substring(2, 6));  //begin index, end index
		
		System.out.println(s.indexOf('x'));     //-1
		System.out.println(s.indexOf('b'));     //1
		System.out.println(s.lastIndexOf('a')); //7
		
		System.out.println(s.contains("cde"));
	}
}
