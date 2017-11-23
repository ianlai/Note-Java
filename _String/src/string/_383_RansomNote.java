package string;

/*
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * You may assume that both strings contain only lowercase letters.
 */
public class _383_RansomNote {

	public static void main(String[] args) {
		_383_RansomNote obj = new _383_RansomNote();
		String r1 = "abc";  
		String r2 = "abbccaab"; 
		String r3 = "abbcaabaaabcaab"; 
		String m  = "aabaabbbkkddccaab";
	
		System.out.println(obj.canConstruct(r1, m));
		System.out.println(obj.canConstruct(r2, m));
		System.out.println(obj.canConstruct(r3, m));
	}
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()==0) return true;
        if(magazine.length()==0) return false;
        
        int[] alpha = new int[26];
        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            int a = (int)c - 97;
            alpha[a]++;
        }
        
        for(int i=0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            int a = (int)c - 97;
            alpha[a]--;
            if(alpha[a]<0) return false;
        }
        return true;
    }
}