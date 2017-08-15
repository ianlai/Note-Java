package syntax;

public class _String {

	public static void main(java.lang.String[] args) {
		
		//Calculate char's occurrence
		String s = "abcdababbcdefg";  //b:4
		Character target = new Character('b');
		int count = s.length() - s.replaceAll(target.toString(),"").length();  //calculate the number of 'b'
		System.out.println(count);
		
		
		//StringBuilder 
		String ss = "";
		StringBuilder sb = new StringBuilder();
		String sb_final;
		int number = 10_000;
		long start_ss = System.nanoTime();
		for(int i=0; i<number; i++){
			ss += i;
		}
		long end_ss = System.nanoTime();
		
		long start_sb = System.nanoTime();
		for(int i=0; i<number; i++){
			sb.append(i);
		}
		sb_final = sb.toString();
		long end_sb = System.nanoTime();
		
		boolean check = (ss.equals(sb_final));
		System.out.println("String equals to StringBuilder? " + check);
		System.out.println("String:        " + (end_ss-start_ss));
		System.out.println("StringBuilder: " + (end_sb-start_sb));
		
		
		//Copying a string doesn't need to use clone because String is immutable. We can copy reference only instead. 
		String s1 = "aaaaabbbbb";
		String s2 = "";
		s2 = s1;
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		s1 = "ooo";
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s2 won't change by s1");
		

		//Type Conversion
		int pp = 3;
		Integer ppp = new Integer(pp);
		String sss1 = String.valueOf(pp);
		String sss2 = ppp.toString();
		String sss3 = "45678";
		Integer ppp2 = Integer.valueOf(sss3);
		System.out.println(sss1 + " " + sss2 + " " + (pp+ppp2));
	}

}
