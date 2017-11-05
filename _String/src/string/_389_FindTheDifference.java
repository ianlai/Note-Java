package string;


/* String s and String t has different order, and String t is added one char from String s.
 * Find the added char.
 */
public class _389_FindTheDifference {

	public static void main(String[] args) {
		_389_FindTheDifference obj = new _389_FindTheDifference();
		char c = obj.findTheDifference("abcd", "dasbc");
		System.out.println(c);
		
	}
    public char findTheDifference(String s, String t) {
        char x = 0;
        for(int i=0;i<s.length();i++){
            x^=s.charAt(i);
        }
        for(int i=0;i<t.length();i++){
            x^=t.charAt(i);
        }
        return x;
    }

}
