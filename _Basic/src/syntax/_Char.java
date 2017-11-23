package syntax;

public class _Char {

	public static void main(String[] args) {
		char c1 = '5';      // '5'
		int  i1 = c1;       // 53 
		int  i2 = (int)c1;  // 53
		int  i3 = c1-48;    //  5  (YES)
		System.out.println(c1 + " " + i1 + " " + i2 + " " + i3);
	}

}
