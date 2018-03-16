package syntax;

public class _AlphabetToInt {
	
	private final String alphabet = "abcdefghijklmonpqrstuvwxyz";

	public static void main(String[] args) {		
		
		_AlphabetToInt z = new _AlphabetToInt();
		byte[] ss = z.toInt("grass");
		for(int i=0; i<ss.length;i++){
			System.out.print(ss[i] + " ");
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
