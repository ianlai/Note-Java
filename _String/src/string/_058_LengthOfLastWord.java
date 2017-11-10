package string;

public class _058_LengthOfLastWord {

	public static void main(String[] args) {
		_058_LengthOfLastWord obj = new _058_LengthOfLastWord();
		int a1 = obj.lengthOfLastWord("what is the last word");
		int a2 = obj.lengthOfLastWord("what is the last word???");
		int a3 = obj.lengthOfLastWord("what is thelastword");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
        int count = 0;
        int guard = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)!=' '){
                guard++;
                count=guard;
            }
            else guard=0;
        }
        return count;
    }

}
