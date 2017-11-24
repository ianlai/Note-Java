package syntax;

public class _Char {

	public static void main(String[] args) {
		/* char -> int (Number) 
		 * '5'  ->  5 
		 */
		
		char c1 = '5';      // '5'
		int  i11 = c1;       // 53 
		int  i12 = (int)c1;  // 53
		int  i13 = c1-48;    //  5   (OK)
		System.out.println(c1 + ": " + i11 + " " + i12 + " " + i13);
		
		/* char -> int (Alphabet) 
		 * 'a'  ->  0 
		 */
		char c2 = 'a';       // 'a'
		int  i21 = c2;       // 97 
		int  i22 = (int)c2;  // 97
		int  i23 = c2-97;    //  a  (OK)
		System.out.println(c2 + ": " + i21 + " " + i22 + " " + i23);
		
		
		char c3 = 'A';       // 'A'
		int  i31 = c3-65;    //  a  (OK)
		System.out.println(c3 + ": " + i31);
		
		
		/* char -> int */
		char mmc = '5';
		int  mmi = Character.getNumericValue(mmc);
		
		/* int  -> char */
		int  mmi2 = 8;
		char mmc2 = Character.forDigit(mmi2, 10);
		
		System.out.println(mmc + " " + mmi);
		System.out.println(mmi2 + " " + mmc2);
	}

}
