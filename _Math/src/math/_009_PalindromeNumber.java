package math;

public class _009_PalindromeNumber {

	public static void main(String[] args) {
		_009_PalindromeNumber obj = new _009_PalindromeNumber();
		int[] arr = new int[]{123,555,877,194878491,-559955,+289982};  //-559955 is not
		for(int e: arr){
			System.out.println(e + ": " + obj.isPalindrome(e));
		}
	}

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            s.substring(1);
        }
        
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}