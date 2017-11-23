package syntax;

public class _String {

	public static void main(java.lang.String[] args) {
		calcCharOccurence();
		stringBuilderUse();
		stringImmutable();
		typeConversion();
		stringEquality();
	}

	public static void calcCharOccurence() {
		// Calculate char's occurrence
		String s = "abcdababbcdefg"; // b:4
		Character target = new Character('b');
		int count = s.length() - s.replaceAll(target.toString(), "").length(); // calculate the number of 'b'
		System.out.println(count);
	}

	public static void stringBuilderUse() {
		// StringBuilder
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

	public static void stringImmutable() {
		// Copying a string doesn't need to use clone because String is immutable. We
		// can copy reference only instead.
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
		System.out.println("===== String Equality =====");

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

}
