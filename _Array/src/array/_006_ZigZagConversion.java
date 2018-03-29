package array;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class _006_ZigZagConversion {

	public static void main(String[] args) {
		_006_ZigZagConversion obj = new _006_ZigZagConversion();
		String r1 = obj.convert("abc"       , 3);
		String r2 = obj.convert("abcdef"    , 4);
		String r3 = obj.convert("abcdefghij", 3);
		String r4 = obj.convert("abcdefghij", 5);
		
		System.out.println(r1);  //abc
		System.out.println(r2);  //abfced
		System.out.println(r3);  //aeibdfhjcg
		System.out.println(r4);  //aibhjcgdfe
	}
    public String convert(String s, int numRows) {
        if(numRows<=1) return s; 
        int len = s.length();
        int interval = 2*numRows-2; 
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            int right = i*2;
            int left  = interval - right;
            //System.out.print(i + ": "); 
            if(i==0 || i==numRows-1){
                for(int j=i; j<len; j+=interval){
                    //System.out.print(j + " ");
                    sb.append(s.charAt(j));
                }
            }else{
                for(int j=i, round=0; j<len ; round++){
                    //System.out.print(j + " ");
                    sb.append(s.charAt(j));
                    j+= (round%2==0 ? left : right);
                }
            }
            //System.out.println(); 
        }
        return new String(sb);
    }
}