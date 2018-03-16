package syntax;

public class _StringFormat {

	public static void main(String[] args) {
		_Random rand = new _Random();
		for(int i=0; i<10; i++) {
			String s = rand.nextString(i);
			/* %-5s: 5 spaces and align left 
			 * If the length is over the space, it won't trim the string. */ 
			String msg = String.format("%-5s====%5s====%-7s====%10s", i, i, s, s); 
			System.out.println(msg);
		}
		
		System.out.println();
		
		for(int i=0; i<10; i++) {
			int r = rand.nextInt(1000);
			int n = (i%2==0)? r: -r; 
			/* %05d: 5 space and align left, the blank space will be filled with '0'
			 * %05s: Error 
			 * %+5d: Add plus or minus sign
			 * */ 
			String msg = String.format("%-5d====%5d====%05d====%+8d", i, r, r, n);  
			System.out.println(msg);
		}
	}
}
