package string;

//Example 1:
//Input: haystack = "hello", needle = "ll"
//Output: 2

//Example 2:
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1

public class _028_ImplementStrStr {

	public static void main(String[] args) {
		_028_ImplementStrStr obj = new _028_ImplementStrStr();
		int r1 = obj.strStr("hello", "ll");
		int r2 = obj.strStr("aaaaa", "bba");
		System.out.println(r1);
		System.out.println(r2);
	}
    public int strStr(String haystack, String needle) {
        int nl = needle.length();
        int hl = haystack.length();
        
        if(hl==0 && nl==0) return 0;
        if(hl==0 && nl!=0) return -1;
       
        for(int i=0; i<=hl-nl; i++){
            String sub = haystack.substring(i, i+nl);
            if(needle.equals(sub)) return i;
        }
        return -1;
    }
}