package syntax;

public class StringToInt {

	public int[] id = new int[5];
	private final String alphabet = "abcdefghijklmonpqrstuvwxyz";
	public StringToInt(){
		System.out.println("StringToInt constructor.");
	}
	
	public class A{
		A(){
			System.out.println("A constructor.");
		}
	}
	public static class B{
		B(){
			System.out.println("B constructor.");
		}
	}
	
	public byte[] toInt(String word) {
		byte[] r = new byte[word.length()];
		for (int i = 0; i < r.length; i++) {
			r[i] = getIndex(word.charAt(i));
		}
		return r;
	}

	private byte getIndex(char c) {
		return (byte) alphabet.indexOf(c);
		
	};
	
	
	
}
