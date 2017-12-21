package stringMath;

public class _043_MultiplyStrings {

	public static void main(String[] args) {
		_043_MultiplyStrings obj = new _043_MultiplyStrings();
		String s1 = "12345";
		String s2 = "678";
		String ans1 = obj.multiplySlow(s1, s2);
		//String ans2 = obj.multiply(s1, s2);
		
		System.out.println(ans1);
		//System.out.println(ans2);
	}
	
	//public String multiply(String num1, String num2){
		
	//}
	
    public String multiplySlow(String num1, String num2) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        if(num1.length()==1 && chars1[0]=='0') return "0";
        if(num2.length()==1 && chars2[0]=='0') return "0";
        
        for(int i=num1.length()-1; i>=0; i--){
            int n1 = Character.getNumericValue(chars1[i]);
            int remain = 0; 
            int round  = 0; 
            tmp = new StringBuilder();
            
            /* Multiply each digit */
            for(int j=num2.length()-1; j>=0; j--){
                int n2 = Character.getNumericValue(chars2[j]);
                int product = n1*n2 + round; 
                remain = product % 10;
                round  = product / 10; 
                //System.out.println(n1 + " " + n2 + " " + product + " " + remain + " " + tmp.toString());
                tmp.insert(0, String.valueOf(remain));
                if(j==0 && round!=0)  tmp.insert(0, String.valueOf(round));
            }
            
            /* Padding 0*/
            int diff = num1.length()-1-i;
            for(int k=0; k<diff; k++){
                tmp.append(0);
            }
            //System.out.println(i + ":" + tmp.toString());
            
            /* Add the current number and the accumulated number */
            String sumString = addStrings(tmp.toString(), ans.toString());
            ans = new StringBuilder(sumString);
        }
        return ans.toString(); 
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