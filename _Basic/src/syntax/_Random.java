package syntax;

import java.util.Random;
import java.util.UUID;

public class _Random extends Random {

	public static void main(String[] args) {
		randInt(30, 10000); //number, range n (0 to n-1)
		randStringUUID(30); 
		randString(30, 8);  //number, length
	}
	public static void randInt(int number, int range) {
		Random rand = new Random();
		for(int i=0; i<number; i++){
			String msg = String.format("%-3s : %6s", i, rand.nextInt(range));
			System.out.println(msg); 
		}
	}
	
	/* Use UUID to generate the random string.
	 * Easy, but note that the alphabet is only from a to f 
	 */
	public static void randStringUUID(int number) {
		for(int i=0; i<number; i++) {
			String s = UUID.randomUUID().toString();  //use UUID as rand string 
			s=s.replaceAll("-", "");                  //remove "-"
			String msg = String.format("%-3s : %6s", i, s);
			System.out.println(msg);
		}
	}
	
	public static void randString(int number, int length) {
		for(int i=0; i<number; i++) {
			String s = nextString(length);
			String msg = String.format("%-3s : %10s", i, s);
			System.out.println(msg);
		}
	}
	 
	public static String nextString(int length) {
		final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String lower = upper.toLowerCase();
		final String digit = "0123456789";
		final String alphanum = upper + lower + digit; 
		final char[] symbol   = alphanum.toCharArray();
		final int range = alphanum.length(); 
		Random rand = new Random();
		
		char[] buf = new char[length];
		for(int i=0; i<length; i++) {
			buf[i] = symbol[rand.nextInt(range)];
		}
		return new String(buf);
	}
}
