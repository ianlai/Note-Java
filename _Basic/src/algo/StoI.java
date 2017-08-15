package algo;

public class StoI {
	public static void main(String[] args) {
		StoI si = new StoI();
		
		String[] ss = new String[10];
		ss[0] = "123";
		ss[1] = "+123";
		ss[2] = "-123";
		ss[3] = "      6789";
		ss[4] = "    ab345678";
		ss[5] = "    23456784567898";
		ss[6] = "      -23456784567898";
		
		
		for(int i=0; i<ss.length; ++i){
			System.out.println("s:" + ss[i]);
			System.out.println("i:" + si.myAtoi(ss[i]));
		}
	}
    public int myAtoi(String str) {
        if(str==null || str.length()==0)   //null check should be at the left 
            return 0;
        
        int first = 0;
        char firstChar='\0';
        int sign;
        for(int i=0; i<str.length(); ++i){
            char c = str.charAt(i);
            if(c!=' '){
                first = i;
                firstChar = c;
                break;
            }
        }
        //System.out.println("First non-space index: " + first);
        
        if(firstChar=='+'){
            sign = 1;
            first++;
        }else if (firstChar=='-'){
            sign = -1;
            first++;
        }else if(Character.isDigit(firstChar)){
            sign = 1;
        }else{
            return 0;
        }
        //System.out.println("Sign mark: " + sign);
        
        int ans=0;
        int base;
        boolean isOverflow = false;
        int thredshold = (Integer.MAX_VALUE)/10;
        
        for(int i=first; i<str.length(); ++i){
            char c = str.charAt(i);
            //System.out.println("char: " + c);
            if(!Character.isDigit(c)) break;
            
            //int tmp1 = (Integer.MAX_VALUE - Character.getNumericValue(c)) / 10; 
            //overflow 
            //if(ans > tmp1){
            if(ans > thredshold || (ans == thredshold && Character.getNumericValue(c) > 7) ){
                if(sign==1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }  
            ans = ans*10 + Character.getNumericValue(c);
            //System.out.println("ans:  " + ans);
        }
        ans = sign * ans; 
        return ans;
    }
}