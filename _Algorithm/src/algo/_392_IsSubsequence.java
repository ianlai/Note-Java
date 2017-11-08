package algo;

public class _392_IsSubsequence {

	public static void main(String[] args) {
		_392_IsSubsequence obj = new _392_IsSubsequence();
		String s1 = "abc", t1 = "ahbgdc";
		String s2 = "axc", t2 = "ahbgdc";
		
		System.out.println(obj.isSubsequence(s1, t1));
		System.out.println(obj.isSubsequence(s2, t2));

	}
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(s.length()!=0 && t.length()==0) return false;
    
        int indexS=0, indexT=0;
        while(true){
            if(s.charAt(indexS)==t.charAt(indexT)) ++indexS; 
            ++indexT;
            if(indexS==s.length()) return true;
            if(indexT==t.length()) return false;
        }
    }
}
