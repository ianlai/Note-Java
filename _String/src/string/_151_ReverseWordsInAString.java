package string;

/*
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */

/* Many many corner cases! 
 * Ex. -> " "      
 *     -> "     "       
 *     -> "  a   b   "
 * */
public class _151_ReverseWordsInAString {

	public static void main(String[] args) {
		_151_ReverseWordsInAString obj = new _151_ReverseWordsInAString();
		String s1 = "aa bbb cc   "; 
		String s2 = "  aa   bbb   cc   "; 
		String s3 = " "; 
		String s4 = "    ";
		
		System.out.println(obj.reverseWords(s1));
		System.out.println(obj.reverseWords(s2));
		System.out.println(obj.reverseWords(s3));
		System.out.println(obj.reverseWords(s4));
	}
	
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        s = s.trim();  //omit the leading and trailing spaces
        if(s.length()==0) return "";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            //System.out.println(i + ":--" + arr[i] + "--");
            if(arr[i].length()==0) continue; 
            //System.out.println(i + ":" + arr[i]);
            sb.append(arr[i] + " ");
        }
        return sb.substring(0, sb.length()-1);
    }
}
