package stringMath;

public class _415_AddStrings {

	public static void main(String[] args) {
		_415_AddStrings obj = new _415_AddStrings();
		String a1 = "0";
		String b1 = "0";
		String c1 = obj.addStrings(a1, b1);
		
		String a2 = "9999";
		String b2 = "222888";
		String c2 = obj.addStrings(a2, b2);
		
		System.out.println(c1);
		System.out.println(c2);

	}
	public String addStrings(String num1, String num2) {
		if(num1.length() >= num2.length()) 
			return _addStrings(num1, num2);
		else
			return _addStrings(num2, num1);
	}
    public String _addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int lmax = Math.max(l1, l2);
        int lmin = Math.min(l1, l2);
          
        boolean large1 = (lmax==l1) ? true : false;
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        char[] cr = new char[lmax+1]; 
        boolean carry = false;
        
    	for(int i=0; i<l1; i++){
    		if(i>=l2){
    			int t1 = Character.getNumericValue(c1[l1-i-1]);
    			int ts = (carry==true) ? t1+1 : t1;
    			
    			if(ts>=10){
    				cr[l1-i] = Character.forDigit(ts%10, 10);
    				carry = true;
    			}else{
    				cr[l1-i] = Character.forDigit(ts, 10);
    				carry = false;
    			}
    			
    		}else{
    			int t1 = Character.getNumericValue(c1[l1-1-i]); //char -> int
    			int t2 = Character.getNumericValue(c2[l2-1-i]);
    			int ts = (carry==true) ? t1+t2+1 : t1+t2;

    			if(ts>=10){
    				cr[l1-i] = Character.forDigit(ts%10, 10);   //int -> char
    				carry = true;
    			}else{
    				cr[l1-i] = Character.forDigit(ts, 10);
    				carry = false;
    			}
    		}
    	}
    	if(carry==true){
    		cr[0] = '1';
    	}
        String ans = new String(cr);
        ans = ans.replace("\u0000", "");   //remove '\u0000'
        return ans;
    }
}
