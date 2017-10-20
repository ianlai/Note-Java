package string;

public class _557_ReverseWordsInAString3 {

	public static void main(String[] args) {
		Solution obj = new Solution();
		String input = "Let's take LeetCode contest";
		String output = obj.reverseWords(input);
		System.out.println(output);
	}
}

class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        char[] carr = s.toCharArray();
        char[] cbrr = new char[s.length()];
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            //System.out.println(i + ":" + carr[i]);
            if(i>0 && carr[i]==' '){
                end = i-1;
                cbrr[i] = ' ';
                swap(carr, cbrr, start, end);
                start = i+1;
            }
        }
        swap(carr, cbrr, start, s.length()-1);
        String res = new String(cbrr);
        return res;
    }
    private void swap(char[] src, char[] dst, int s, int e){
        //System.out.println("----------");
        //System.out.println(src);
        //System.out.println(dst);
        //System.out.println(s + "-" + e);
        
        for(int i=s; i<=e;i++){
            dst[e-(i-s)] = src[i];
        }
        //System.out.println(dst);
        //System.out.println("----------");
    }
}