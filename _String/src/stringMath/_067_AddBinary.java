package stringMath;

/* Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

public class _067_AddBinary {

	public static void main(String[] args) {
		_067_AddBinary obj = new _067_AddBinary();
		String s1 = "101";
		String s2 = "10111";
		String s3 = "1111101";
		String s4 = "1001001110";
		String s5 = "10110010010011";
		
		System.out.println(obj.addBinary(s1, s1));
		System.out.println(obj.addBinary(s1, s2));
		System.out.println(obj.addBinary(s1, s3));
		System.out.println(obj.addBinary(s4, s5));	
	}

    public String addBinary(String a, String b) {
        /* Let a longer than b */
        if(a.length()<b.length()){
            String tmp = b; 
            b = a;
            a = tmp; 
        }
        int diff = a.length() - b.length();
        StringBuilder sb = new StringBuilder();
        int ia = a.length()-1;
        int ib = b.length()-1;
        boolean carry = false;
        
        /* Add a and b (and carry) from the end until b is finished */
        for(int i=0; i<b.length(); i++){
            int oneNum = 0;
            if(a.charAt(ia)=='1') oneNum++;
            if(b.charAt(ib)=='1') oneNum++;
            if(carry) oneNum++;
            if(oneNum==0){
                sb.append('0');
                carry=false;
            }else if(oneNum==1){
                sb.append('1');
                carry=false;
            }else if(oneNum==2){
                sb.append('0');
                carry=true;
            }else if(oneNum==3){
                sb.append('1');
                carry=true;
            }
            ia--;
            ib--;
        }
        /* Add a (and carry) from the end where b is finished */
        for(int i=0; i<diff; i++){
            int oneNum = 0;
            if(a.charAt(ia)=='1') oneNum++;
            if(carry) oneNum++;
            if(oneNum==0){
                sb.append('0');
                carry=false;
            }else if(oneNum==1){
                sb.append('1');
                carry=false;
            }else if(oneNum==2){
                sb.append('0');
                carry=true;
            }
            ia--;
        }
        /* Add carry only (in case the bit round up after a is finished)*/
        if(carry) 
            sb.append('1');
        
        /* Reverse the StringBuilder */
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            res.append(sb.charAt(sb.length()-1-i));
        }
        return new String(res);
    }
}